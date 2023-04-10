package com.wzssoft.bettercheesemodel.common.block;


import java.util.Optional;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

/**
 * the following code is copied from Minecraft 23w13a_or_b
 * @reference cake
 */
public class CheeseBlock extends Block {
    public static final int field_44222 = 8;
    private static final int field_44227 = 256;
    public static final int field_44223 = 255;
    private static final int field_44228 = 0;
    public static final IntProperty SLICES = IntProperty.of("slices", 1, 255);
    public static final VoxelShape[] CORNER_SHAPES = Util.make(new VoxelShape[8], cornerShapes -> {
        cornerShapes[0] = VoxelShapes.cuboid(0.0, 0.0, 0.0, 0.5, 0.5, 0.5);
        cornerShapes[1] = VoxelShapes.cuboid(0.5, 0.0, 0.0, 1.0, 0.5, 0.5);
        cornerShapes[2] = VoxelShapes.cuboid(0.0, 0.0, 0.5, 0.5, 0.5, 1.0);
        cornerShapes[3] = VoxelShapes.cuboid(0.5, 0.0, 0.5, 1.0, 0.5, 1.0);
        cornerShapes[4] = VoxelShapes.cuboid(0.0, 0.5, 0.0, 0.5, 1.0, 0.5);
        cornerShapes[5] = VoxelShapes.cuboid(0.5, 0.5, 0.0, 1.0, 1.0, 0.5);
        cornerShapes[6] = VoxelShapes.cuboid(0.0, 0.5, 0.5, 0.5, 1.0, 1.0);
        cornerShapes[7] = VoxelShapes.cuboid(0.5, 0.5, 0.5, 1.0, 1.0, 1.0);
    });
    public static final VoxelShape[] SHAPES = Util.make(new VoxelShape[256], voxelShapes -> {
        for (int i = 0; i < ((VoxelShape[]) voxelShapes).length; ++i) {
            VoxelShape voxelShape = VoxelShapes.empty();
            for (int j = 0; j < 8; ++j) {
                if (!CheeseBlock.hasCorner(i, j)) continue;
                voxelShape = VoxelShapes.union(voxelShape, CORNER_SHAPES[j]);
            }
            voxelShapes[i] = voxelShape.simplify();
        }
    });
    private static final int field_44229 = -1;

    public CheeseBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(SLICES, 255));
    }

    private static boolean hasCorner(int flags, int corner) {
        return (flags & CheeseBlock.createFlag(corner)) != 0;
    }

    private static int createFlag(int corner) {
        return 1 << corner;
    }

    private static int removeCorner(int flags, int corner) {
        return flags & ~CheeseBlock.createFlag(corner);
    }

    private static boolean isFull(BlockState state) {
        return state.get(SLICES) == 255;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!player.getStackInHand(hand).isEmpty()) {
            return ActionResult.FAIL;
        }
        Vec3d vec3d = hit.getPos().subtract(pos.getX(), pos.getY(), pos.getZ());
        int i = CheeseBlock.getClosestSlice(state, vec3d);
        if (i == -1) {
            return ActionResult.FAIL;
        }
        int j = CheeseBlock.removeCorner(state.get(SLICES), i);
        if (j != 0) {
            world.setBlockState(pos, (BlockState) state.with(SLICES, j));
        } else {
            world.removeBlock(pos, false);
            world.emitGameEvent((Entity) player, GameEvent.BLOCK_DESTROY, pos);
        }
        if (!world.isClient) {
            world.syncWorldEvent(2010, pos, i);
            player.getHungerManager().add(2, 0.2f);
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS, 0.5f, 0.5f);
            world.emitGameEvent((Entity) player, GameEvent.EAT, pos);
        } else {
            //display particle
            world.addBlockBreakParticles(pos, this.getDefaultState());
        }

        return ActionResult.SUCCESS;
    }

    private static int getClosestSlice(BlockState state, Vec3d pos) {
        int i = state.get(SLICES);
        double d = Double.MAX_VALUE;
        int j = -1;
        for (int k = 0; k < CORNER_SHAPES.length; ++k) {
            double e;
            VoxelShape voxelShape;
            Optional<Vec3d> optional;
            if (!CheeseBlock.hasCorner(i, k) || !(optional = (voxelShape = CORNER_SHAPES[k]).getClosestPointTo(pos)).isPresent() || !((e = optional.get().squaredDistanceTo(pos)) < d))
                continue;
            d = e;
            j = k;
        }
        return j;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPES[state.get(SLICES)];
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return CheeseBlock.isFull(state) ? 0.2f : 1.0f;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SLICES);
    }
}
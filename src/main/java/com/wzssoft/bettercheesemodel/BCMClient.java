package com.wzssoft.bettercheesemodel;

import com.wzssoft.bettercheesemodel.registry.BCMBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;


public class BCMClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        //oak leaves cheese
        BlockRenderLayerMap.INSTANCE.putBlock(BCMBlocks.OAK_LEAVES_BLOCK, RenderLayer.getCutout());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x30bb0b, BCMBlocks.OAK_LEAVES_BLOCK);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world.getColor(pos, BiomeColors.FOLIAGE_COLOR), BCMBlocks.OAK_LEAVES_BLOCK);
    }
}

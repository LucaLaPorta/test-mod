package fr.skiwark.testmod.util;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IModelLoader {

    @SideOnly(Side.CLIENT)
    void registerModels();

    default void registerModel(Item item, int metadata){
        if(item.getRegistryName() == null) return;
        registerModel(item, metadata, item.getRegistryName());
    }

    default void registerModel(Item item, int metadata, ResourceLocation resourceLocation){
        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(resourceLocation, "inventory"));
    }

}

package fr.skiwark.testmod.listener;

import fr.skiwark.testmod.TestMod;
import fr.skiwark.testmod.item.ItemWand;
import fr.skiwark.testmod.util.IModelLoader;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID)
public class ItemRegistryListener {

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<Item> event) {
        registerItem(event, (new ItemWand().setRegistryName("wand").setUnlocalizedName("wand")));
    }

    private static void registerItem(RegistryEvent.Register<Item> event, Item item) {
        event.getRegistry().register(item);
        if(FMLCommonHandler.instance().getEffectiveSide().isClient() && item instanceof IModelLoader) {
            registerModels((IModelLoader) item);
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerModels(IModelLoader modelLoader) {
        modelLoader.registerModels();
    }

}

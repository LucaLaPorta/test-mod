package fr.skiwark.testmod.item;

import fr.skiwark.testmod.util.IModelLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemWand extends Item implements IModelLoader {

    public ItemWand() {
        setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        if(!worldIn.isRemote) {
            EntityPolarBear Polar = new EntityPolarBear(worldIn);
            playerIn.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY,5*20));
            Polar.setPosition(playerIn.posX,playerIn.posY,playerIn.posZ);
            worldIn.spawnEntity(Polar);

        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void registerModels() {
        registerModel(this, 0);
    }

}

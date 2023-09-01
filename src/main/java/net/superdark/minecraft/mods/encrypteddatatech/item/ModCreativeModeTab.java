package net.superdark.minecraft.mods.encrypteddatatech.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.superdark.minecraft.mods.encrypteddatatech.EncryptedDataTechMod;

public class ModCreativeModeTab
{
    public static final CreativeModeTab Tab = new CreativeModeTab(EncryptedDataTechMod.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CrudeOilBucket.get());
        }
    };
}

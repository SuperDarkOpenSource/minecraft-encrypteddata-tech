package net.superdark.minecraft.mods.encrypteddatatech.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.superdark.minecraft.mods.encrypteddatatech.EncryptedDataTechMod;

/**
 * Based on tutorial by Kaupenjoe
 */
public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EncryptedDataTechMod.MODID);

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}

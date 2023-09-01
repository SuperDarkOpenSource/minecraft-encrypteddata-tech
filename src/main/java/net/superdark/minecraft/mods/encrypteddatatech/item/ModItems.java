package net.superdark.minecraft.mods.encrypteddatatech.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.superdark.minecraft.mods.encrypteddatatech.EncryptedDataTechMod;
import net.superdark.minecraft.mods.encrypteddatatech.fluid.ModFluids;

/**
 * Based on tutorial by Kaupenjoe
 */
public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EncryptedDataTechMod.MODID);

    public static final RegistryObject<Item> CrudeOilBucket = ITEMS.register("crude_oil_bucket",
            () -> new BucketItem(ModFluids.CrudeOilSource,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}

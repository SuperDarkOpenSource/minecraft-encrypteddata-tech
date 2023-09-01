package net.superdark.minecraft.mods.encrypteddatatech.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.superdark.minecraft.mods.encrypteddatatech.EncryptedDataTechMod;
import net.superdark.minecraft.mods.encrypteddatatech.block.entity.ExampleFacingBlockEntity;
import net.superdark.minecraft.mods.encrypteddatatech.item.ModCreativeModeTab;
import net.superdark.minecraft.mods.encrypteddatatech.item.ModItems;

import java.util.function.Supplier;

import static net.superdark.minecraft.mods.encrypteddatatech.block.entity.ModBlockEntities.EXAMPLE_FACING_BLOCK_ENTITY;

/**
 * Based on tutorial by Kaupenjoe
 */
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EncryptedDataTechMod.MODID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = registerBlock("example_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)), ModCreativeModeTab.Tab);

     public static final RegistryObject<Block> EXAMPLE_FACING_BLOCK = registerBlock("example_facing_block",
            () -> new HorizontalOrientableBlock<>(BlockBehaviour.Properties.copy(Blocks.ANVIL),
                                                  EXAMPLE_FACING_BLOCK_ENTITY),
                                                  ModCreativeModeTab.Tab);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> result = BLOCKS.register(name, block);
        registerBlockItem(name, result, tab);

        return result;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name,
                                                                            RegistryObject<T> block, CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}

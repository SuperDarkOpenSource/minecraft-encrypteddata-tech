package net.superdark.minecraft.mods.encrypteddatatech.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.superdark.minecraft.mods.encrypteddatatech.EncryptedDataTechMod;
import net.superdark.minecraft.mods.encrypteddatatech.block.ModBlocks;

// Credit to: https://www.youtube.com/@TurtyWurty
public class ModBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EncryptedDataTechMod.MODID);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Place entities below
    ////////////////////////
    public static final RegistryObject<BlockEntityType<ExampleFacingBlockEntity>> EXAMPLE_FACING_BLOCK_ENTITY =
            ENTITIES.register("example_facing_block",
                    () -> BlockEntityType.Builder.of(ExampleFacingBlockEntity::new,
                            ModBlocks.EXAMPLE_FACING_BLOCK.get()).build(null)); // intellij complains about passing null to non-nullable, dw about it. it has to do with mojang and data fixers for fixing data in between versions.
}

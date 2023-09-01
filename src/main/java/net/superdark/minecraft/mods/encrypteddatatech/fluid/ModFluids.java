package net.superdark.minecraft.mods.encrypteddatatech.fluid;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.superdark.minecraft.mods.encrypteddatatech.EncryptedDataTechMod;
import net.superdark.minecraft.mods.encrypteddatatech.block.ModBlocks;
import net.superdark.minecraft.mods.encrypteddatatech.item.ModItems;

public class ModFluids
{
    public static final DeferredRegister<Fluid> Fluids = DeferredRegister.create(ForgeRegistries.FLUIDS, EncryptedDataTechMod.MODID);

    public static final RegistryObject<FlowingFluid> CrudeOilSource = Fluids.register("crude_oil_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.CrudeOilProperties));
    public static final RegistryObject<FlowingFluid> CrudeOilFlowing = Fluids.register("crude_oil_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.CrudeOilProperties));

    public static final ForgeFlowingFluid.Properties CrudeOilProperties =
            new ForgeFlowingFluid.Properties(ModFluidTypes.CrudeOil, CrudeOilSource, CrudeOilFlowing)
                    .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.CrudeOil)
                    .bucket(ModItems.CrudeOilBucket);

    public static void register(IEventBus eventBus)
    {
        Fluids.register(eventBus);
    }
}

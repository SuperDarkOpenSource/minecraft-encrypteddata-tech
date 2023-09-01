package net.superdark.minecraft.mods.encrypteddatatech.fluid;

import com.mojang.math.Vector3f;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.superdark.minecraft.mods.encrypteddatatech.EncryptedDataTechMod;

public class ModFluidTypes
{
    public static final DeferredRegister<FluidType> FluidTypes =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, EncryptedDataTechMod.MODID);


    public static final FluidType.Properties CrudeOilProperties = FluidType.Properties.create().lightLevel(1).density(1)
            .viscosity(1).sound(SoundAction.get("drink"), SoundEvents.BEE_STING).fallDistanceModifier(10f)
            .canSwim(false).canDrown(true);
    public static final RegistryObject<FluidType> CrudeOil = FluidTypes.register("crude_oil_fluid",
            () -> new CustomFluidType(ModFluidResourceLocations.WaterStill, ModFluidResourceLocations.WaterFlowing,
                    ModFluidResourceLocations.CrudeOilOverlay, 0xFF141414, new Vector3f(0f/255f, 0f/255f, 0f/255f),
                    CrudeOilProperties, 0.25f, 1.25f));

    public static void register(IEventBus eventBus)
    {
        FluidTypes.register(eventBus);
    }
}

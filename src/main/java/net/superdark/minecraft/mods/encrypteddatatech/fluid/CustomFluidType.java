package net.superdark.minecraft.mods.encrypteddatatech.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.math.Vector3f;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

/**
 * Based on class from Kaupenjoe tutorial
 */
public class CustomFluidType extends FluidType
{
    private final ResourceLocation _stillTexture;
    private final ResourceLocation _flowingTexture;
    private final ResourceLocation _overlayTexture;
    private final int _tintColor;
    private final Vector3f _fogColor;
    private final float _fogStart;
    private final float _fogEnd;

    public CustomFluidType(final ResourceLocation stillTexture, final ResourceLocation flowingTexture,
                           final ResourceLocation overlayTexture, final int tintColor, final Vector3f fogColor,
                           final Properties properties, final float fogStart, float fogEnd)
    {
        super(properties);
        _stillTexture = stillTexture;
        _flowingTexture = flowingTexture;
        _overlayTexture = overlayTexture;
        _tintColor = tintColor;
        _fogColor = fogColor;
        _fogStart = fogStart;
        _fogEnd = fogEnd;
    }

    public ResourceLocation getStillTexture() {
        return _stillTexture;
    }

    public ResourceLocation getFlowingTexture() {
        return _flowingTexture;
    }

    public ResourceLocation getOverlayTexture() {
        return _overlayTexture;
    }

    public int getTintColor() {
        return _tintColor;
    }

    public Vector3f getFogColor() {
        return _fogColor;
    }

    public float getFogStart() {
        return _fogStart;
    }

    public float getFogEnd() {
        return _fogEnd;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public int getTintColor() {
                return _tintColor;
            }

            @Override
            public ResourceLocation getStillTexture() {
                return _stillTexture;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return _flowingTexture;
            }

            @Override
            public @Nullable ResourceLocation getOverlayTexture() {
                return _overlayTexture;
            }

            @Override
            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return _fogColor;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(_fogStart);
                RenderSystem.setShaderFogEnd(_fogEnd);
            }
        });
    }
}

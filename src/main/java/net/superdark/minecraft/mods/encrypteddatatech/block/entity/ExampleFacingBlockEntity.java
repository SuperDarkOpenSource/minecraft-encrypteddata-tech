package net.superdark.minecraft.mods.encrypteddatatech.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ExampleFacingBlockEntity extends BlockEntity
{

    public ExampleFacingBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.EXAMPLE_FACING_BLOCK_ENTITY.get(), pos, state);
    }
}

package net.superdark.minecraft.mods.encrypteddatatech.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class  HorizontalOrientableBlock <T extends BlockEntity> extends HorizontalDirectionalBlock implements EntityBlock
{
    private final RegistryObject<BlockEntityType<T>> _blockEntityType;

    public HorizontalOrientableBlock(Properties p, RegistryObject<BlockEntityType<T>> blockEntityType)
    {
        super(p);
        _blockEntityType = blockEntityType;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state)
    {
        return _blockEntityType.get().create(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        // Sets the default block state the OPPOSITE direction you are facing. (faces the front of the block towards you.)
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}

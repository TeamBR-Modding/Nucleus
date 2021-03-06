package com.pauljoda.nucleus.common.blocks;

import com.pauljoda.nucleus.util.WorldUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

/**
 * This file was created for Nucleus - Java
 *
 * Nucleus - Java is licensed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 *
 * @author Paul Davis - pauljoda
 * @since 2/9/2017
 */
public interface IToolable {

    /**
     * Called to get what stack should be dropped on wrench
     * @param world The world
     * @param pos The position of the block
     * @return The stack to drop in the world
     */
    @Nonnull
    ItemStack getStackDroppedByWrench(World world, BlockPos pos);

    /**
     * Called when a wrench clicks on this block
     * @param context Use info
     * @return The result, pass to send to next, success to end
     */
    @SuppressWarnings("ConstantConditions")
    default ActionResultType onWrench(ItemUseContext context) {
        if(context.getPlayer().isSneaking() && WorldUtils.breakBlockSavingNBT(context.getWorld(),
                context.getPos(), (IToolable) context.getWorld().getBlockState(context.getPos()).getBlock()))
            return ActionResultType.SUCCESS;
        else
            return ActionResultType.FAIL;
    }
}

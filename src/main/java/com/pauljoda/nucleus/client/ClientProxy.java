package com.pauljoda.nucleus.client;

import com.pauljoda.nucleus.common.CommonProxy;
import com.pauljoda.nucleus.events.ToolTipEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

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
public class ClientProxy extends CommonProxy {
    /**
     * Called on init
     */
    @Override
    public void init() {
        MinecraftForge.EVENT_BUS.register(new ToolTipEvent());
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getPlayer() {
        return Minecraft.getInstance().player;
    }
}

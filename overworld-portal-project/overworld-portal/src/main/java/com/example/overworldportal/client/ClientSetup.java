package com.example.overworldportal.client;

import com.example.overworldportal.OverworldPortalMod;
import com.example.overworldportal.registry.ModBlockEntities;
import net.minecraft.client.renderer.blockentity.TheEndPortalRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// PASSO 8: só no CLIENTE. Liga o renderer do portal do End ao nosso tipo de block entity.
// É isso que faz os dois portais terem EXATAMENTE a mesma aparência.
@Mod.EventBusSubscriber(modid = OverworldPortalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.OVERWORLD_PORTAL.get(), TheEndPortalRenderer::new);
    }
}

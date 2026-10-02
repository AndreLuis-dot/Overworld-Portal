package com.example.overworldportal;

import com.example.overworldportal.registry.ModBlockEntities;
import com.example.overworldportal.registry.ModBlocks;
import com.example.overworldportal.registry.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// PASSO 1: ponto de entrada. O valor de @Mod precisa ser igual ao mod_id do gradle.properties.
@Mod(OverworldPortalMod.MOD_ID)
public class OverworldPortalMod {
    public static final String MOD_ID = "overworldportal";

    public OverworldPortalMod() {
        // O "event bus" do mod: onde o Forge avisa sobre registro, setup, etc.
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Cada DeferredRegister se pendura no bus. Quando for a hora de registrar, o Forge chama as lambdas.
        // A ORDEM IMPORTA: bloco -> item (usa o bloco) -> block entity (usa o bloco).
        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        ModBlockEntities.BLOCK_ENTITIES.register(bus);

        bus.addListener(this::addToCreativeTab);
    }

    // Coloca o item na aba "Blocos funcionais" do criativo, para você poder pegar e testar.
    private void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModItems.OVERWORLD_PORTAL);
        }
    }
}

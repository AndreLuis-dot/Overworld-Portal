package com.example.overworldportal.registry;

import com.example.overworldportal.OverworldPortalMod;
import com.example.overworldportal.block.OverworldPortalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// PASSO 2: registrar o bloco.
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OverworldPortalMod.MOD_ID);

    public static final RegistryObject<Block> OVERWORLD_PORTAL = BLOCKS.register("overworld_portal",
            () -> new OverworldPortalBlock(
                    // Mesmas propriedades do bloco original do portal do End (Blocks.END_PORTAL).
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BLACK)
                            .noCollission()                  // dá para atravessar
                            .lightLevel(state -> 15)         // emite luz máxima
                            .strength(-1.0F, 3600000.0F)     // indestrutível, como bedrock
                            .noLootTable()                   // não dropa nada
                            .pushReaction(PushReaction.BLOCK)// pistão não empurra
            ));
}

package com.example.overworldportal.registry;

import com.example.overworldportal.OverworldPortalMod;
import com.example.overworldportal.block.OverworldPortalBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// PASSO 4: registrar o "tipo" da block entity, ligando-o ao nosso bloco.
public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, OverworldPortalMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<OverworldPortalBlockEntity>> OVERWORLD_PORTAL =
            BLOCK_ENTITIES.register("overworld_portal", () ->
                    BlockEntityType.Builder
                            .of(OverworldPortalBlockEntity::new, ModBlocks.OVERWORLD_PORTAL.get())
                            .build(null)); // o null é o "data fixer type", não usamos
}

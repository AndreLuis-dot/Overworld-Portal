package com.example.overworldportal.block;

import com.example.overworldportal.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.TheEndPortalBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

// PASSO 5: a aparência de "céu estrelado" do portal NÃO vem do bloco, vem do RENDERER da block entity.
// Herdando de TheEndPortalBlockEntity, reaproveitamos o comportamento (renderiza só a face de cima).
// O renderer de verdade é registrado em ClientSetup.
public class OverworldPortalBlockEntity extends TheEndPortalBlockEntity {
    public OverworldPortalBlockEntity(BlockPos pos, BlockState state) {
        // Usamos o NOSSO tipo, e não BlockEntityType.END_PORTAL.
        super(ModBlockEntities.OVERWORLD_PORTAL.get(), pos, state);
    }
}

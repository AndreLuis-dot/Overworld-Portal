package com.example.overworldportal.teleport;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

// PASSO 7: o ITeleporter do Forge define ONDE a entidade aparece depois de trocar de dimensão.
//
// Obs.: como esta classe NÃO é o PortalForcer do vanilla, isVanilla() já retorna false e o Forge
// não dispara os créditos finais quando um jogador vai do End para o Overworld.
public class OverworldTeleporter implements ITeleporter {

    // Aqui escolhemos o ponto de chegada. "defaultPortalInfo" é o cálculo vanilla, que ignoramos.
    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld,
                                    Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        BlockPos spawn = destWorld.getSharedSpawnPos();
        // Sobe até a superfície, para não nascer dentro de uma montanha. Isso carrega o chunk se preciso.
        BlockPos top = destWorld.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, spawn);
        Vec3 position = Vec3.atBottomCenterOf(top);

        // Parâmetros: posição, velocidade (zero), rotação horizontal e vertical (mantém a atual).
        return new PortalInfo(position, Vec3.ZERO, entity.getYRot(), entity.getXRot());
    }
}

package com.example.overworldportal.block;

import com.example.overworldportal.teleport.OverworldTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EndPortalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;

// PASSO 6: o bloco. Herdar de EndPortalBlock nos dá forma, partículas, "não substituível", etc.
// Só mudamos DUAS coisas: qual block entity usar e o que acontece quando uma entidade entra.
public class OverworldPortalBlock extends EndPortalBlock {

    public OverworldPortalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new OverworldPortalBlockEntity(pos, state);
    }

    // Chamado todo tick em que uma entidade encosta no bloco.
    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        // 1) Só no servidor. ServerLevel só existe lá; o instanceof já filtra o cliente.
        if (!(level instanceof ServerLevel serverLevel)) return;
        // 2) Se já está no Overworld, não faz nada.
        if (level.dimension() == Level.OVERWORLD) return;
        // 3) Algumas entidades não podem trocar de dimensão (ex.: passageiros de outra entidade).
        if (!entity.canChangeDimensions()) return;
        // 4) A entidade precisa estar DENTRO da área do portal (a caixa fina de 6/16 a 12/16 de altura).
        boolean inside = Shapes.joinIsNotEmpty(
                Shapes.create(entity.getBoundingBox().move(-pos.getX(), -pos.getY(), -pos.getZ())),
                state.getShape(level, pos),
                BooleanOp.AND);
        if (!inside) return;

        ServerLevel overworld = serverLevel.getServer().getLevel(Level.OVERWORLD);
        if (overworld != null) {
            // O 2º argumento diz COMO teleportar. É aqui que escolhemos o destino.
            entity.changeDimension(overworld, new OverworldTeleporter());
        }
    }
}

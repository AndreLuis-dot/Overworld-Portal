package com.example.overworldportal.registry;

import com.example.overworldportal.OverworldPortalMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// PASSO 3: um BlockItem é o "item que coloca o bloco". O portal original não tem, o nosso terá.
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OverworldPortalMod.MOD_ID);

    public static final RegistryObject<Item> OVERWORLD_PORTAL = ITEMS.register("overworld_portal",
            () -> new BlockItem(ModBlocks.OVERWORLD_PORTAL.get(), new Item.Properties()));
}

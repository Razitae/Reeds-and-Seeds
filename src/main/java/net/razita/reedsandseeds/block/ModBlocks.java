package net.razita.reedsandseeds.block;
import net.minecraft.world.level.block.SoundType;
import net.razita.reedsandseeds.ReedsAndSeeds;
import net.razita.reedsandseeds.item.ModCreativeModeTab;
import net.razita.reedsandseeds.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ReedsAndSeeds.MOD_ID);

    public static final RegistryObject<Block> MOSS_BRICKS = registerBlock("moss_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(0.8f).sound(SoundType.MOSS)), ModCreativeModeTab.REEDSANDSEEDS_TAB);

    public static final RegistryObject<Block> PACKED_MOSS = registerBlock("packed_moss",
            () -> new Block(BlockBehaviour.Properties.of(Material.MOSS)
                    .strength(0.6f).sound(SoundType.MOSS)), ModCreativeModeTab.REEDSANDSEEDS_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

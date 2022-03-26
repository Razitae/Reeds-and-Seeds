package net.razita.reedsandseeds.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.razita.reedsandseeds.block.ModBlocks;

public class ModCreativeModeTab {
    public static final CreativeModeTab REEDSANDSEEDS_TAB = new CreativeModeTab("reedsandseedstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.PACKED_MOSS.get());
        }
    };
}

package com.mamailes.gabbysgrove.init;

import com.google.common.base.Suppliers;
import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.function.Supplier;

public class GGBlockSetTypes {

    public static final BlockSetType CHROMATIC_SET = BlockSetType.register(new BlockSetType(GabbysGrove.prefix("chromatic").toString()));






    public static BlockSetType registerBlockSetType(final String name, final boolean canOpenByHand,
                                                    final boolean canOpenByWindCharge, final boolean canButtonBeActivatedByArrows,
                                                    final BlockSetType.PressurePlateSensitivity pressurePlateSensitivity,
                                                    final SoundType defaultSound, final SoundEvent doorCloseSound,
                                                    final SoundEvent doorOpenSound, final SoundEvent trapdoorCloseSound,
                                                    final SoundEvent trapdoorOpenSound, final SoundEvent pressurePlateClickOffSound,
                                                    final SoundEvent pressurePlateClickOnSound, final SoundEvent buttonClickOffSound,
                                                    final SoundEvent buttonClickOnSound) {

        return BlockSetType.register(new BlockSetType(GabbysGrove.MODID,
                        canOpenByHand,
                        canOpenByWindCharge,
                        canButtonBeActivatedByArrows,
                        pressurePlateSensitivity,
                        defaultSound,
                        doorCloseSound,
                        doorOpenSound,
                        trapdoorCloseSound,
                        trapdoorOpenSound,
                        pressurePlateClickOffSound,
                        pressurePlateClickOnSound,
                        buttonClickOffSound,
                        buttonClickOnSound
                )
        );
    }

}

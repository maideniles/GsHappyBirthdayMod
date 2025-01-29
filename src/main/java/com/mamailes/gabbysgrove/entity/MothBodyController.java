package com.mamailes.gabbysgrove.entity;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.control.BodyRotationControl;

public class MothBodyController extends BodyRotationControl {
    private final Moth moth;

    public MothBodyController(Moth moth) {
        super(moth);
        this.moth = moth;
    }

    @Override
    public void clientTick() {
        this.moth.yBodyRot = this.moth.getYRot();
        this.moth.yHeadRot = Mth.rotateIfNecessary(this.moth.yHeadRot, this.moth.yBodyRot, this.moth.getMaxHeadYRot());
    }
}
package com.mamailes.gabbysgrove.entity;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

public class MothMoveController extends MoveControl {
    private final Moth moth;

    public MothMoveController(Moth moth) {
        super(moth);
        this.moth = moth;
    }

    @Override
    public void tick() {
        // original movement behavior if the entity isn't flying
        if (!this.moth.isFlying()) {
            super.tick();
            return;
        }

        if (this.operation == MoveControl.Operation.MOVE_TO) {
            this.operation = MoveControl.Operation.WAIT;
            double xDif = this.wantedX - this.mob.getX();
            double yDif = this.wantedY - this.mob.getY();
            double zDif = this.wantedZ - this.mob.getZ();
            double sq = xDif * xDif + yDif * yDif + zDif * zDif;
            if (sq < (double) 2.5000003E-7F) {
                this.mob.setYya(0.0F);
                this.mob.setZza(0.0F);
                return;
            }

            float speed = (float) (this.speedModifier * this.mob.getAttributeValue(Attributes.FLYING_SPEED));
            double distSq = Math.sqrt(xDif * xDif + zDif * zDif);
            this.mob.setSpeed(speed);
            if (Math.abs(yDif) > (double) 1.0E-5F || Math.abs(distSq) > (double) 1.0E-5F)
                this.mob.setYya((float) yDif * speed);

            float yaw = (float) (Mth.atan2(zDif, xDif) * (double) (180F / (float) Math.PI)) - 90.0F;
            this.mob.setYRot(rotlerp(this.mob.getYRot(), yaw, 6));
        }
        else {
            this.mob.setYya(0);
            this.mob.setZza(0);
        }
    }
}
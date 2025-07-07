package com.github.imagineforgee.myths_awakening.entitys.cerberus.goals;

import com.github.imagineforgee.myths_awakening.entitys.cerberus.Cerberus;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class CerberusAttackGoal extends MeleeAttackGoal {
    private final Cerberus cerberus;

    public CerberusAttackGoal(Cerberus cerberus, double speed, boolean useLongMemory) {
        super(cerberus, speed, useLongMemory);
        this.cerberus = cerberus;
    }

    @Override
    public void tick() {
        super.tick();

        LivingEntity target = this.mob.getTarget();
        if (target != null && this.mob.getSensing().hasLineOfSight(target)) {
            double distanceToTargetSqr = this.mob.distanceToSqr(target.getX(), target.getY(), target.getZ());
            double attackReachSqr = this.getAttackReachSqr(target);

            if (distanceToTargetSqr <= attackReachSqr && this.mob.swinging) {
                cerberus.performAttack();
            }
        }
    }

}
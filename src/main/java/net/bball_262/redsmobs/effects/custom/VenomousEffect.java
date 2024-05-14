package net.bball_262.redsmobs.effects.custom;

import net.bball_262.redsmobs.effects.ModEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class VenomousEffect extends MobEffect {
    public VenomousEffect() {
        super(MobEffectCategory.HARMFUL,65280);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(this == ModEffects.VENOMOUS_EFFECT.get())
            pLivingEntity.hurt(pLivingEntity.damageSources().generic(), 2 * (pAmplifier + 1));
    }

    @Override
    public boolean isBeneficial() {
        return false;
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        int i = 25 >> pAmplifier;
        int duration = pDuration / 2;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }
}
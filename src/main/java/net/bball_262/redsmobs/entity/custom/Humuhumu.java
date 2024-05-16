package net.bball_262.redsmobs.entity.custom;

import net.bball_262.redsmobs.items.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FollowFlockLeaderGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class Humuhumu extends AbstractSchoolingFish {
    @Nullable
    private AbstractSchoolingFish leader;
    private int schoolSize = 1;
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public Humuhumu(EntityType<? extends AbstractSchoolingFish> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder CreateAttributes() {
        return WaterAnimal.createLivingAttributes().add(Attributes.MAX_HEALTH, 2F)
                .add(Attributes.MOVEMENT_SPEED, 0.4F)
                .add(Attributes.ARMOR_TOUGHNESS, 0F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2F)
                .add(Attributes.FOLLOW_RANGE, 10F);
    }
    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.BUCKET_OF_HUMUHUMU.get());
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    protected void updateWalkAnimation(float v) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.walkAnimation.update(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
        if (this.hasFollowers() && this.level().random.nextInt(200) == 1) {
            List<? extends AbstractFish> $$0 = this.level().getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(8.0, 8.0, 8.0));
            if ($$0.size() <= 1) {
                this.schoolSize = 1;
            }
        }
    }
}
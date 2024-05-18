package net.bball_262.redsmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.bball_262.redsmobs.RedsMobs;
import net.bball_262.redsmobs.entity.custom.Humuhumu;
import net.bball_262.redsmobs.entity.custom.Snail;
import net.bball_262.redsmobs.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.TropicalFish;

public class HumuhumuRenderer extends MobRenderer<Humuhumu, HumuhumuModel<Humuhumu>> {
    private static final ResourceLocation HUMUHUMU_LOCATION = new ResourceLocation(RedsMobs.MODID, "textures/entity/humuhumu.png");
    public HumuhumuRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HumuhumuModel<>(pContext.bakeLayer(ModModelLayers.HUMUHUMU_LAYER)), 0.2F);
    }

    protected void setupRotations(Humuhumu pEntityLiving, PoseStack pPoseStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
        super.setupRotations(pEntityLiving, pPoseStack, pAgeInTicks, pRotationYaw, pPartialTicks);
        float x = 4.3F * Mth.sin(0.6F * pAgeInTicks);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(x));
        if (!pEntityLiving.isInWater()) {
            pPoseStack.translate(0.2F, 0F, 0.0F);
            pPoseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }

    }

    @Override
    public ResourceLocation getTextureLocation(Humuhumu humuhumu) {
        return HUMUHUMU_LOCATION;
    }
}
package net.bball_262.redsmobs.entity.client;

import net.bball_262.redsmobs.RedsMobs;
import net.bball_262.redsmobs.entity.custom.SnailEntity;
import net.bball_262.redsmobs.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SnailRenderer extends MobRenderer<SnailEntity, SnailModel<SnailEntity>> {
    private static final ResourceLocation SNAIL_LOCATION = new ResourceLocation(RedsMobs.MODID, "textures/entity/snail.png");
    public SnailRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SnailModel<>(pContext.bakeLayer(ModModelLayers.SNAIL_LAYER)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(SnailEntity snail) {
        return SNAIL_LOCATION;
    }
}
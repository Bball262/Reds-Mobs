package net.bball_262.redsmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bball_262.redsmobs.entity.animations.ModAnimationDefinitions;
import net.bball_262.redsmobs.entity.custom.SnailEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class SnailModel<T extends SnailEntity> extends HierarchicalModel<SnailEntity> {
	private final ModelPart body;
	private final ModelPart shell;
	private final ModelPart eyestalk1;
	private final ModelPart eyestalk2;

	public SnailModel(ModelPart root) {
		this.body = root.getChild("body");
		this.shell = body.getChild("shell");
		this.eyestalk1 = body.getChild("eyestalk1");
		this.eyestalk2 = body.getChild("eyestalk2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition shell = body.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = shell.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition eyestalk1 = body.addOrReplaceChild("eyestalk1", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.0F, -2.5F));

		PartDefinition cube_r3 = eyestalk1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 3).addBox(3.0F, -2.0F, -1.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 3.5F, 0.0F, 1.5708F, 0.0F));

		PartDefinition eyestalk2 = body.addOrReplaceChild("eyestalk2", CubeListBuilder.create(), PartPose.offset(1.0F, -1.0F, -2.5F));

		PartDefinition cube_r4 = eyestalk2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(3.0F, -2.0F, -1.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 3.5F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return body;
	}

	@Override
	public void setupAnim(SnailEntity snail, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.SNAIL_WALK, limbSwing, limbSwingAmount, 0.25f, 2.5f);
		this.animate(snail.idleAnimationState, ModAnimationDefinitions.SNAIL_IDLE, ageInTicks, 1f);
	}
}
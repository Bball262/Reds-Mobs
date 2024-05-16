package net.bball_262.redsmobs.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.bball_262.redsmobs.entity.animations.ModAnimationDefinitions;
import net.bball_262.redsmobs.entity.custom.Humuhumu;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class HumuhumuModel<T extends Humuhumu> extends HierarchicalModel<Humuhumu> {
	private final ModelPart Body;
	private final ModelPart TopFin1;
	private final ModelPart BottomFin1;
	private final ModelPart SideFin1;
	private final ModelPart SideFin2;
	private final ModelPart TopFin2;
	private final ModelPart TailFin1;
	private final ModelPart TailFin2;

	public HumuhumuModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.TopFin1 = Body.getChild("TopFin1");
		this.BottomFin1 = Body.getChild("BottomFin1");
		this.SideFin1 = Body.getChild("SideFin1");
		this.SideFin2 = Body.getChild("SideFin2");
		this.TopFin2 = Body.getChild("TopFin2");
		this.TailFin1 = Body.getChild("TailFin1");
		this.TailFin2 = TailFin1.getChild("TailFin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.5F, 1.0F));

		PartDefinition TopFin1 = Body.addOrReplaceChild("TopFin1", CubeListBuilder.create().texOffs(0, 6).addBox(0.0F, -4.5F, -2.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -1.0F));

		PartDefinition BottomFin1 = Body.addOrReplaceChild("BottomFin1", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, -0.5F, -2.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -1.0F));

		PartDefinition SideFin1 = Body.addOrReplaceChild("SideFin1", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.0F, -2.5F));

		PartDefinition cube_r1 = SideFin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, -1).addBox(0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5672F, 0.0F));

		PartDefinition SideFin2 = Body.addOrReplaceChild("SideFin2", CubeListBuilder.create(), PartPose.offset(0.5F, 1.0F, -2.5F));

		PartDefinition cube_r2 = SideFin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, -1).addBox(0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.5672F, 0.0F));

		PartDefinition TopFin2 = Body.addOrReplaceChild("TopFin2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -4.5F, -3.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -1.0F));

		PartDefinition TailFin1 = Body.addOrReplaceChild("TailFin1", CubeListBuilder.create().texOffs(7, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TailFin2 = TailFin1.addOrReplaceChild("TailFin2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public ModelPart root() {
		return Body;
	}

	@Override
	public void setupAnim(Humuhumu humuhumu, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.HUMU_SWIM, limbSwing, limbSwingAmount, 0.25f, 2.5f);
		this.animate(humuhumu.idleAnimationState, ModAnimationDefinitions.HUMU_IDLE, ageInTicks, 1f);
	}
}
package com.github.imagineforgee.myths_awakening.entitys;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

import java.util.UUID;

public class HitboxPart extends PartEntity<LivingEntity> {
    private UUID parentId;
    private Vec3 localOffset = Vec3.ZERO;
    private LivingEntity parent;
    public final String name;
    private final EntityDimensions size;


    public HitboxPart(LivingEntity pParentMob, String pName, float pWidth, float pHeight) {
        super(pParentMob);
        this.size = EntityDimensions.scalable(pWidth, pHeight);
        this.refreshDimensions();
        this.parent = pParentMob;
        this.name = pName;
    }

    public void initParent(LivingEntity parent, Vec3 offset) {
        this.parent = parent;
        this.parentId = parent.getUUID();
        this.localOffset = offset;
        this.refreshDimensions();
        moveToParent();
    }

    @Override
    public void tick() {
        super.tick();

        if (parent == null && parentId != null && this.level() instanceof ServerLevel serverLevel) {
            Entity entity = serverLevel.getEntity(parentId);
            if (entity instanceof LivingEntity living) {
                this.parent = living;
            }
        }

        if (parent == null || !parent.isAlive()) {
            discard();
            return;
        }

        moveToParent();
    }

    private void moveToParent() {
        if (localOffset == null || parent == null) return;

        Vec3 parentPos = parent.position();
        Vec3 target = parentPos.add(localOffset);

        setPos(target);
        double halfWidth = this.getBbWidth() / 2.0;
        double height = this.getBbHeight();
        setBoundingBox(new AABB(
                target.x - halfWidth, target.y, target.z - halfWidth,
                target.x + halfWidth, target.y + height, target.z + halfWidth
        ));
    }

    public void updateOffset(Vec3 newOffset) {
        this.localOffset = newOffset;
        moveToParent();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return parent != null && parent.hurt(source, amount);
    }

    @Override
    protected void defineSynchedData() {}

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        if (parentId != null && localOffset != null) {
            tag.putUUID("ParentID", parentId);
            tag.putDouble("OffX", localOffset.x);
            tag.putDouble("OffY", localOffset.y);
            tag.putDouble("OffZ", localOffset.z);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        if (tag.hasUUID("ParentID")) {
            this.parentId = tag.getUUID("ParentID");
            this.localOffset = new Vec3(
                    tag.getDouble("OffX"),
                    tag.getDouble("OffY"),
                    tag.getDouble("OffZ")
            );
        }
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean is(Entity entity) {
        return this == entity || this.parent == entity;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return super.getAddEntityPacket(); // or implement custom packet if needed
    }

    @Override
    public boolean shouldBeSaved() {
        return false;
    }
}

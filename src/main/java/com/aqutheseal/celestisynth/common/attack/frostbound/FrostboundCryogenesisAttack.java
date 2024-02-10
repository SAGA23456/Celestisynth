package com.aqutheseal.celestisynth.common.attack.frostbound;

import com.aqutheseal.celestisynth.api.animation.player.AnimationManager;
import com.aqutheseal.celestisynth.common.attack.base.WeaponAttackInstance;
import com.aqutheseal.celestisynth.common.entity.skill.SkillCastFrostboundIceCast;
import com.aqutheseal.celestisynth.common.registry.CSEntityTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class FrostboundCryogenesisAttack extends WeaponAttackInstance {
    public FrostboundCryogenesisAttack(Player player, ItemStack stack) {
        super(player, stack);
    }

    @Override
    public AnimationManager.AnimationsList getAnimation() {
        return AnimationManager.AnimationsList.ANIM_FROSTBOUND_CRYOGENESIS;
    }

    @Override
    public int getCooldown() {
        return 160;
    }

    @Override
    public int getAttackStopTime() {
        return 0;
    }

    @Override
    public boolean getCondition() {
        return player.isShiftKeyDown();
    }

    @Override
    public void startUsing() {
        if (!level.isClientSide()) {
            SkillCastFrostboundIceCast frostboundIceCast = CSEntityTypes.FROSTBOUND_ICE_CAST.get().create(level);
            frostboundIceCast.setOwnerUuid(player.getUUID());
            frostboundIceCast.setCastLevel(5);
            frostboundIceCast.setAngleX((float) (calculateXLook(player) * 3));
            frostboundIceCast.setAngleZ((float) (calculateZLook(player) * 3));
            frostboundIceCast.moveTo(player.getX() + (calculateXLook(player) * 3), getFloorPositionUnderPlayerYLevel(level, player.blockPosition()) + 2, player.getZ() + (calculateZLook(player) * 3));
            level.addFreshEntity(frostboundIceCast);
        }
    }

    @Override
    public void tickAttack() {
    }

    @Override
    public void stopUsing() {
    }
}

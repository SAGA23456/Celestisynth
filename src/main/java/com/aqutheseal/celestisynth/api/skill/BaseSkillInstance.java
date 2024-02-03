package com.aqutheseal.celestisynth.api.skill;

import com.aqutheseal.celestisynth.common.attack.base.WeaponAttackInstance;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

public abstract class BaseSkillInstance implements ISkillInstance {
    protected final Component skillName;
    protected final Component skillDescription;
    protected final Component skillCriterionDescription;
    protected final ResourceLocation skillIcon;
    protected final ISkillTier skillTier;
    protected final int minSkillLevel;
    protected final int maxSkillLevel;
    protected final int skillCooldown;

    public BaseSkillInstance(Component skillName, Component skillDescription, Component skillCriterionDescription, ResourceLocation skillIcon, ISkillTier skillTier, int minSkillLevel, int maxSkillLevel, int skillCooldown) {
        this.skillName = skillName;
        this.skillDescription = skillDescription;
        this.skillCriterionDescription = skillCriterionDescription;
        this.skillIcon = skillIcon;
        this.skillTier = skillTier;
        this.minSkillLevel = minSkillLevel;
        this.maxSkillLevel = maxSkillLevel;
        this.skillCooldown = skillCooldown;
    }

    @Override
    public Component getName() {
        return skillName;
    }

    @Override
    public Component getDescription() {
        return skillDescription;
    }

    @Override
    public Component getCriterionDescription() {
        return skillCriterionDescription;
    }

    @Override
    public ResourceLocation getIcon() {
        return skillIcon;
    }

    @Nullable
    @Override
    public abstract WeaponAttackInstance getAttack();

    @Override
    public ISkillTier getTier() {
        return skillTier;
    }

    @Nullable
    @Override
    public abstract AbstractSkillTree getSkillTree();

    @Override
    public int getMinSkillLevel() {
        return minSkillLevel;
    }

    @Override
    public int getMaxSkillLevel() {
        return maxSkillLevel;
    }

    @Override
    public int getSkillCooldown() {
        return skillCooldown;
    }

    @Override
    public abstract boolean isPassive();

    @Override
    public abstract boolean getActivationConditions(Player owner);

    @Override
    public abstract boolean getDeactivationConditions(Player owner);

    @Override
    public abstract void onSkillLearned(Player owner);

    @Override
    public abstract void onSkillUnlearned(Player owner);

    @Override
    public abstract void onSkillLevelChanged(Player owner, boolean hasDecreased);

    @Override
    public abstract void onSkillActivated(Player owner);

    @Override
    public abstract void onSkillTick(Player owner);

    @Override
    public abstract void onPassiveTick(Player owner);

    @Override
    public abstract void onSkillDeactivated(Player owner);

    @Override
    public abstract void setSkillLevel(int newSkillLevel);

    @Override
    public abstract void setTier(ISkillTier newTier);

    @Override
    public abstract void setAttack(@Nullable WeaponAttackInstance newAttack, boolean interruptCurrentAttack);

    @Override
    public abstract void setDescription(Component newDescription);

    @Override
    public abstract CompoundTag serializeToNBT();
}

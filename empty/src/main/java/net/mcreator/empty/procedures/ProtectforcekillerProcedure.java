package net.mcreator.empty.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ProtectforcekillerProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "name")) {
				entityiterator.stopRiding();
				if (entityiterator instanceof Mob _entity)
					_entity.getNavigation().stop();
				if (entityiterator instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
					_livingEntity2.getAttribute(Attributes.MAX_HEALTH).setBaseValue(0);
				if (entityiterator instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
					_livingEntity3.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
				if (entityiterator instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()))
					_livingEntity4.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).setBaseValue(0);
				if (entityiterator instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH))
					_livingEntity5.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(0);
				if (entityiterator instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()))
					_livingEntity6.getAttribute(ForgeMod.BLOCK_REACH.get()).setBaseValue(0);
				if (entityiterator instanceof LivingEntity _entity)
					_entity.removeAllEffects();
				entityiterator.setSecondsOnFire(9999);
				entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("empty:emptydamage")))),
						entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
				entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("empty:emptydamage")))),
						(float) Double.POSITIVE_INFINITY);
				if (entityiterator instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) - Double.POSITIVE_INFINITY));
				if (entityiterator instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - Double.POSITIVE_INFINITY));
				if (entityiterator instanceof LivingEntity _entity)
					_entity.setHealth(0);
				if (!entityiterator.level().isClientSide())
					entityiterator.discard();
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74\u00A7l\u60A8\u5DF2\u88AB\u6740\u6B7B"), false);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}

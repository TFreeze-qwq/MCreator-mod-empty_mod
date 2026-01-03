package net.mcreator.empty.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class IstrueProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "name")) {
				if (BoolArgumentType.getBool(arguments, "if") == true) {
					entityiterator.getPersistentData().putBoolean("protect", true);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u60A8\u5DF2\u88AB\u4FDD\u62A4"), true);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u60A8\u5DF2\u88AB\u53D7\u5230\u4FDD\u62A4"), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u6CE8\u610F\uFF1A\u5728\u4FDD\u62A4\u4E2D\u6B7B\u4EA1\u65F6\u4FDD\u62A4\u4F1A\u81EA\u52A8\u5931\u6548\uFF0C\u9700\u8981\u91CD\u65B0/Protect"), false);
				} else if (BoolArgumentType.getBool(arguments, "if") == false) {
					entityiterator.getPersistentData().putBoolean("protect", false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u60A8\u5DF2\u88AB\u53D6\u6D88\u4FDD\u62A4"), true);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}

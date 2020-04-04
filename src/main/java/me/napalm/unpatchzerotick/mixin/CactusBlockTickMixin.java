package me.napalm.unpatchzerotick.mixin;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CactusBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(CactusBlock.class)
public class CactusBlockTickMixin {
	@Shadow
	public void randomTick(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {}

	@Inject(at = @At("TAIL"), method = "scheduledTick")
	public void scheduledTick(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random, CallbackInfo info) {
		this.randomTick(state, world, pos, random);
	}
}
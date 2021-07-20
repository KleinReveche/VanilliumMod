package com.klr2003.anaesia.unpatches.zerotick;

import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

// this abstracts Kelp, TwistingVines and WeepingVines
@Mixin(AbstractPlantStemBlock.class)
public class ZeroTickAbstractPlantStemBlock {
    @Shadow
    public void randomTick(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random) {}

    @Inject(at = @At("TAIL"), method = "randomTick(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)V")
    public void randomTick(final BlockState state, final ServerWorld world, final BlockPos pos, final Random random, CallbackInfo info) {
        if(!world.isAir(pos.down())) {
            this.randomTick(state, world, pos, random);
        }
    }
}
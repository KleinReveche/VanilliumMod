package com.klr2003.anaesia.blocks;

import java.util.Random;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class OxidizableStairsBlock extends StairsBlock implements Oxidizable {
   private final Oxidizable.OxidizationLevel oxidizationLevel;

   public OxidizableStairsBlock(Oxidizable.OxidizationLevel oxidizationLevel, BlockState baseBlockState, Settings settings) {
      super(baseBlockState, settings);
      this.oxidizationLevel = oxidizationLevel;
   }

   public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
      this.tickDegradation(state, world, pos, random);
   }

   public boolean hasRandomTicks(BlockState state) {
      return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
   }

   public Oxidizable.OxidizationLevel getDegradationLevel() {
      return this.oxidizationLevel;
   }
}

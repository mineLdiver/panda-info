package net.mine_diver.pandainfo.entity;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PandaInteractionListener implements UseEntityCallback {

    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        if (player.isSneaking() && entity instanceof PandaEntity panda) player.sendMessage(
                Texts.join(List.of(
                        Text.translatable("gui.panda-info.main_gene", Text.translatable("gui.panda-info.gene." + panda.getMainGene())).formatted(Formatting.GOLD),
                        Text.translatable("gui.panda-info.hidden_gene", Text.translatable("gui.panda-info.gene." + panda.getHiddenGene())).formatted(Formatting.AQUA),
                        Text.translatable("gui.panda-info.product_gene", Text.translatable("gui.panda-info.gene." + panda.getProductGene())).formatted(Formatting.GREEN)
                ), Text.of(" | ")),
                true
        );
        return ActionResult.PASS;
    }
}

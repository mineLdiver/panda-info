package net.mine_diver.pandainfo;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.mine_diver.pandainfo.entity.PandaInteractionListener;

public class PandaInfo implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UseEntityCallback.EVENT.register(new PandaInteractionListener());
    }
}

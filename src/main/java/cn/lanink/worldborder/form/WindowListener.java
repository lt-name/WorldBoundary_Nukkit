package cn.lanink.worldborder.form;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindowSimple;

public class WindowListener implements Listener {

    @EventHandler
    public void onResponded(PlayerFormRespondedEvent event) {
        Player player = event.getPlayer();
        if (player == null || event.getWindow() == null || event.getResponse() == null) {
            return;
        }
        if (event.getWindow() instanceof FormWindowSimple &&
                event.getFormID() == WindowCreate.ADMIN_MENU) {
            FormWindowSimple simple = (FormWindowSimple) event.getWindow();
            switch (simple.getResponse().getClickedButtonId()) {
                case 0:
                    Server.getInstance().dispatchCommand(player, "worldborder pos1");
                    break;
                case 1:
                    Server.getInstance().dispatchCommand(player, "worldborder pos2");
                    break;
                case 2:
                    Server.getInstance().dispatchCommand(player, "worldborder delete");
                    break;
                case 3:
                    Server.getInstance().dispatchCommand(player, "worldborder reload");
                    break;
                default:
                    break;
            }
        }
    }

}

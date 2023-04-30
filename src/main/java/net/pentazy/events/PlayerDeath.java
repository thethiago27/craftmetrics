package net.pentazy.events;

import net.pentazy.utils.PlayerDeathEventUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath extends PlayerDeathEventUtils implements Listener {

  @EventHandler
  private void playerDeathEvent(PlayerDeathEvent e) {

    PlayerDeathEventUtils playerDeathEventUtils = new PlayerDeathEventUtils();
    playerDeathEventUtils.player = e.getEntity();

    playerDeathEventUtils.increaseDeaths();
  }


}

package net.pentazy.utils;

import net.pentazy.craftmetrics.MySQL;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PlayerDeathEventUtils {

  public Player player;

  public Optional<Player> setPlayer(Player player) {
    return Optional.ofNullable(this.player = player);
  }

  public void increaseDeaths() {
    try {
      int deaths = getDeaths();
      MySQL.execute("UPDATE playerdata SET deaths='" + (deaths + 1) + "' WHERE uuid='" + player.getUniqueId() + "'");
    } finally {
      MySQL.close();
    }
  }

  public int getDeaths() {
    try (ResultSet rs = MySQL.execute("SELECT * FROM playerdata WHERE uuid='" + player.getUniqueId() + "'")) {
      if (rs != null && rs.next()) {
        return rs.getInt("deaths");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      MySQL.close();
    }
    return 0;
  }

}

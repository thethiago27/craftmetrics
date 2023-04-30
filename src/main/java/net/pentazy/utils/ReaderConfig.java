package net.pentazy.utils;

import net.pentazy.craftmetrics.Main;

public class ReaderConfig {

  public String getConfig(String path) {
    return Main.getInstance().getConfig().getString(path);
  }

  public int getConfigInt(String path) {
    return Main.getInstance().getConfig().getInt(path);
  }

  public boolean getConfigBoolean(String path) {
    return Main.getInstance().getConfig().getBoolean(path);
  }

}

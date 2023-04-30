package net.pentazy.utils;

import net.pentazy.commands.Metrics;

public class CommandHelper {

  public boolean isCommand(String command) {
    return command.startsWith("/");
  }

  public String getCommand(String command) {
    return command.substring(1);
  }

  public String getCommandName(String command) {
    return command.split(" ")[0];
  }

  public String[] getCommandArgs(String command) {
    return command.substring(command.indexOf(" ") + 1).split(" ");
  }

}

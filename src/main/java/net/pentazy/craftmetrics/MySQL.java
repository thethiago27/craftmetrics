package net.pentazy.craftmetrics;

import net.pentazy.utils.ReaderConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

  private static Connection connection;
  private static final ReaderConfig readerConfig = new ReaderConfig();

  public static synchronized void init() {
    try {
      String host = readerConfig.getConfig("MYSQL.HOST");
      int port = readerConfig.getConfigInt("MYSQL.PORT");
      String user = readerConfig.getConfig("MYSQL.USER");
      String password = readerConfig.getConfig("MYSQL.PASSWORD");
      String database = readerConfig.getConfig("MYSQL.DATABASE");

      connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static Connection getConnection() {
    return connection;
  }

  public static void close() {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static ResultSet execute(String update) {
    try {
      connection.createStatement().execute(update);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

}

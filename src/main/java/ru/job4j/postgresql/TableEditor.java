package ru.job4j.postgresql;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/idea_db";
            String login = properties.getProperty("login");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) throws Exception  {
            String sql = String.format("create table %s;", tableName);
            getStatement(sql);
    }

    public void dropTable(String tableName) throws Exception {
            String sql = String.format("drop table %s;", tableName);
            getStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
            String sql = String.format("ALTER TABLE %s ADD COLUMN %s %s text;", tableName,
                    columnName, type);
            getStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
            String sql = String.format("ALTER TABLE %s DROP COLUMN %s;", tableName, columnName);
            getStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
            String sql = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;",
                    tableName, columnName, newColumnName);
            getStatement(sql);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
   private void getStatement(String sql) {
       try (Statement statement = connection.createStatement()) {
               statement.execute(sql);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
}

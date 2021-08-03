package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Александр Литвинов
 * @version 1
 * @since 02.08.21
 *
 * Класс для работы с БД
 */
public class ImportDB {
    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    /**
     * метод чтения из файла
     *
     * @return users
     * @throws IOException
     */
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
           // rd.lines().forEach();
            for (String line = rd.readLine(); line != null; line = rd.readLine()) {
                String[] strAr = line.split(";");
                User user = new User(strAr[0], strAr[1]);
                users.add(user);
            }
        }
        return users;
    }

    /**
     * метод добовления в БД
     * @param users
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users(nameUser,email) values(?,?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream("/Users/aleksandrlitvinov/projects/job4j_design/src/main/resources/app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "/Users/aleksandrlitvinov/projects/job4j_design/dump.txt");
        db.save(db.load());
    }
}

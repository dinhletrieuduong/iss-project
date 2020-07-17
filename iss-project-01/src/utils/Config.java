package utils;

import java.io.*;
import java.util.Properties;

public class Config {
    private static String fileName = "config.properties";
    private static String host = "localhost";
    private static String port = "1521";
    private static String username = "SYSTEM";
    private static String password = "ORACLE";

    public static void open() {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(fileName));
            host = prop.getProperty("host");
            port = prop.getProperty("port");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        } catch (Exception e) { }
    }

    public static void save() {
        try {
            Properties prop = new Properties();
            OutputStream of = new FileOutputStream(fileName);
            prop.setProperty("host", host);
            prop.setProperty("port", port);
            prop.setProperty("username", username);
            prop.setProperty("password", password);
            prop.store(of, null);
        } catch (Exception e) { }
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        Config.host = host;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        Config.port = port;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Config.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Config.password = password;
    }
}

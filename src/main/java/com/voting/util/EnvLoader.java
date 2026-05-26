package com.voting.util;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {

    public static void init() {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("jdbc.driver", dotenv.get("JDBC_DRIVER"));
        System.setProperty("jdbc.ip", dotenv.get("JDBC_IP"));
        System.setProperty("jdbc.dbase", dotenv.get("JDBC_DBASE"));
        System.setProperty("jdbc.username", dotenv.get("JDBC_USERNAME"));
        System.setProperty("jdbc.password", dotenv.get("JDBC_PASSWORD"));
    }
}

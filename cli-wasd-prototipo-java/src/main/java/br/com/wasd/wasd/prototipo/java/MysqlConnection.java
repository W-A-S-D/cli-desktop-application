package br.com.wasd.wasd.prototipo.java;

import org.apache.commons.dbcp2.BasicDataSource;

public class MysqlConnection {

    private BasicDataSource dataSource;

    public MysqlConnection() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/wasd?useLegacyDatetimeCode=false&serverTimezone=America/New_York");
        dataSource.setUsername("root");
        dataSource.setPassword("urubu100");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}

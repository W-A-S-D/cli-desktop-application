package br.com.wasd.wasd.prototipo.java;

import org.apache.commons.dbcp2.BasicDataSource;

public class MysqlConnection {

    private BasicDataSource dataSource;

    public MysqlConnection() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/wasd?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("my");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}

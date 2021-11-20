package br.com.wasd.wasd.prototipo.java;

import org.apache.commons.dbcp2.BasicDataSource;

public class Connection {

    private BasicDataSource dataSource;

    public Connection() {
        dataSource = new BasicDataSource();

        dataSource​.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://bdwasdmonitoramento.database.windows.net:1433;database=bdWasdMonitoramento;user=wasd@bdwasdmonitoramento;password=#Gfgrupo5;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource​.setUsername("wasd");
        dataSource​.setPassword("#Gfgrupo5");

    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}

package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Connection;
import br.com.wasd.wasd.prototipo.java.MysqlConnection;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author manocchio
 */
public class DAOConnection {
    
    protected MysqlConnection config = new MysqlConnection();
    protected JdbcTemplate jdbcTemplate = new JdbcTemplate(config.getDataSource());

}

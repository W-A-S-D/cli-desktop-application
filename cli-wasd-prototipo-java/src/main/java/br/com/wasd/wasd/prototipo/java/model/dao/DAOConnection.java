/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.model.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class LogDao extends DAOConnection implements DAO {

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findOne(String param) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void insert(Object object) {
        String sql = "insert into log(fk_maquina, freq_cpu, uso_ram, temperatura) values (?, ?, ?, ?)";
        Log log = (Log) object;
        jdbcTemplate.update(sql, log.getFk_maquina(), log.getFreq_cpu(), log.getUso_ram(), log.getTemperatura());
        System.out.println("Log inserido com sucesso!");
    }

    public int keyInsert(Object object) {
        String sql = "insert into log(fk_maquina, freq_cpu, uso_ram, temperatura) values (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Log log = (Log) object;
        try {
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    PreparedStatement insertLog = con.prepareStatement(sql, new String[]{"log_id"});
                    insertLog.setInt(1, log.getFk_maquina());
                    insertLog.setDouble(2, log.getFreq_cpu());
                    insertLog.setDouble(3, log.getUso_ram());
                    insertLog.setDouble(4, log.getTemperatura());
    
                    return insertLog;
                }
            }, keyHolder);
    
        } catch (Exception e) {
            System.out.println(e);
        }
        return keyHolder.getKey().intValue();
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public List findAllBy(String param) {
        // TODO Auto-generated method stub
        return null;
    }
}

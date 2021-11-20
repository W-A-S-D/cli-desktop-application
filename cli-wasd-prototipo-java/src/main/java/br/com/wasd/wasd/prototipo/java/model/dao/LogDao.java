/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.model.Log;
import java.util.List;

public class LogDao extends DAOConnection implements DAO {

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findOne(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Object object) {
        String sql = "insert into log(fk_maquina, freq_cpu, uso_ram, temperatura, criado) values (3, ?, ?, ?, ?)";
        Log log = (Log)object;
        jdbcTemplate.update(sql, log.getFreq_cpu(), log.getUso_ram(), log.getTemperatura(), log.getCriado());
        System.out.println("Log inserido com sucesso!");
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

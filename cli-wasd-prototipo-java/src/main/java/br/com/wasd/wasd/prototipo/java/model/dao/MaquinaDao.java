/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.model.Maquina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import br.com.wasd.wasd.prototipo.java.mapper.MaquinaMapper;

/**
 *
 * @author bianc
 */
public class MaquinaDao extends DAOConnection implements DAO {

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findOne(String param) {
        String sql = "select * from maquina where nome = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[] { param }, new MaquinaMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void insert(Object object) {
        String sql = "insert into maquina(fk_setor, nome, so, cpu, ram, gpu, status) "
                + "values (?, ?, ?, ?, ?, ?, ?)";
        Maquina maquina = (Maquina) object;

        jdbcTemplate.update(sql, maquina.getFk_setor(), maquina.getNome(), maquina.getSo(), maquina.getCpu(),
                maquina.getRam(), maquina.getGpu(), maquina.getStatus());

        System.out.println("Maquina inserido com sucesso!");
    }

    public int keyInsert(Object object) {
        String sql = "insert into maquina(fk_setor, nome, so, cpu, ram, gpu, status) "
                + "values (?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        Maquina maquina = (Maquina) object;
        try {
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    PreparedStatement insertLog = con.prepareStatement(sql, new String[] { "maquina_id" });
                    insertLog.setInt(1, maquina.getFk_setor());
                    insertLog.setString(2, maquina.getNome());
                    insertLog.setString(3, maquina.getSo());
                    insertLog.setString(4, maquina.getCpu());
                    insertLog.setDouble(5, maquina.getRam());
                    insertLog.setString(6, maquina.getGpu());
                    insertLog.setString(7, maquina.getStatus());

                    return insertLog;
                }
            }, keyHolder);

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Maquina inserido com sucesso!");
        return keyHolder.getKey().intValue();
    }

    @Override
    public void update(Object object) {
        Maquina maquina = (Maquina) object;
        try {
            jdbcTemplate.update("update maquina set status = ? where maquina_id = ?",
                    maquina.getStatus(),
                    maquina.getMaquina_id());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List findAllBy(String param) {
        // TODO Auto-generated method stub
        return null;
    }
}

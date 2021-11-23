/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.mapper.DiscoMapper;
import br.com.wasd.wasd.prototipo.java.model.DiscoMaquina;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author byumi
 */
public class DiscoDao extends DAOConnection implements DAO {

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
        String sql = "insert into disco(fk_maquina, nome, volume) values (?, ?, ?)";
        DiscoMaquina disco = (DiscoMaquina) object;
        jdbcTemplate.update(sql, disco.getMaquina_id(), disco.getNome_disco(), disco.getVolume_disco());

        System.out.println("Disco inserido com sucesso!");
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

    public List<DiscoMaquina> findAllBy(int param) {
        try {
            String sql = "select * from disco where fk_maquina = ? ";
            return jdbcTemplate.query(sql, new DiscoMapper(), new Object[] { param });

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

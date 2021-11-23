package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Connection;
import br.com.wasd.wasd.prototipo.java.model.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import br.com.wasd.wasd.prototipo.java.mapper.UsuarioMapper;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

public class UsuarioDAO extends DAOConnection implements DAO {


    public Usuario login(String email, String senha) {

        String sql = "select * from USUARIO where email =? and senha=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email, senha}, new UsuarioMapper());

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

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
        
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAllBy(String param) {
        // TODO Auto-generated method stub
        return null;
    }

}

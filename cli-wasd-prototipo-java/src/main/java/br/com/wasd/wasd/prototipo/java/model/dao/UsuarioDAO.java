package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Bcrypt;
import br.com.wasd.wasd.prototipo.java.model.Usuario;
import br.com.wasd.wasd.prototipo.java.mapper.UsuarioMapper;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

public class UsuarioDAO extends DAOConnection implements DAO {
    private Bcrypt bcrypt;

    public Usuario login(String email, String senha) {
        bcrypt = new Bcrypt();
        String access;

        //String sql = "select * from usuario where email =? and senha=?";
        String sql = "select * from usuario where email =?";
        try {
            access = jdbcTemplate.queryForObject(sql, new Object[]{email}, new UsuarioMapper()).getSenha();
            if (bcrypt.checkPassDAO(senha, access) == true) {
                return jdbcTemplate.queryForObject(sql, new Object[]{email}, new UsuarioMapper());
            } else {
                return null;
            }

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findOne(String param
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Object object
    ) {

    }

    @Override
    public void update(Object object
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAllBy(String param
    ) {
        // TODO Auto-generated method stub
        return null;
    }

}

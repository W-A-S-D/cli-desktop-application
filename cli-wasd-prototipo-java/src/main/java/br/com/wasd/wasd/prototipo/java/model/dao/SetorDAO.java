package br.com.wasd.wasd.prototipo.java.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import br.com.wasd.wasd.prototipo.java.mapper.SetorMapper;

public class SetorDAO extends DAOConnection implements DAO {
    
    @Override
    public List findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List findAllBy(String param) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object findOne(String param) {
      return null;
    }

    public Object findOne(int param) {
        String sql = "select * from setor where fk_usuario= ?";
        try {
            return jdbcTemplate.queryForObject(sql, new SetorMapper(),  new Object[] { param } );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void insert(Object object) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Object object) {
        // TODO Auto-generated method stub
        
    }
    
}

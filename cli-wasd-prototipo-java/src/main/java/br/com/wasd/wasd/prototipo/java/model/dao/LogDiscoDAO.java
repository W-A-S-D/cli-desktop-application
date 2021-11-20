package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.model.LogDisco;
import java.util.List;

public class LogDiscoDAO extends DAOConnection implements DAO {


    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findOne(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Object object) {
        String sql = "insert into log(fk_log, fk_disco, uso_disco) values (?, ?, ?)";
        LogDisco log = (LogDisco)object;
        jdbcTemplate.update(sql, log.getFk_log(), log.getFk_disco(), log.getUso_disco());
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

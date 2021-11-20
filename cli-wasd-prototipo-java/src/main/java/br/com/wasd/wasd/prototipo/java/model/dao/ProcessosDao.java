/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.Connection;
import br.com.wasd.wasd.prototipo.java.mapper.ProcessosMapper;
//import br.com.wasd.wasd.prototipo.java.model.Processos;
import com.github.britooo.looca.api.group.processos.Processo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author bianc
 */
public class ProcessosDao extends DAOConnection implements DAO {

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findOne(String param) {
        String sql = "select * from processo where nome = ? and fk_maquina = 3";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{param}, new ProcessosMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void insert(Object object) {
        String sql = "insert into processo(fk_maquina, nome, usoCpu, usoMemoria) values (3, ?, ?, ?)";
        Processo processo = (Processo) object;
        jdbcTemplate.update(sql, processo.getNome(), processo.getUsoCpu(), processo.getUsoMemoria());

        System.out.println("Processos inserido com sucesso!");
    }

    @Override
    public void update(Object object) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        df.setTimeZone(tz);
        String timeString = df.format(System.currentTimeMillis());
        Date date = null;
        try {
            date = df.parse(timeString);
        } catch (ParseException ex) {
            Logger.getLogger(ProcessosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(date.getTime());
        String sql = "UPDATE processo SET usoCpu = ?, usoMemoria = ?, atualizado = ? WHERE nome = ? AND fk_maquina = 3;";
        Processo processo = (Processo) object;
        jdbcTemplate.update(sql, processo.getUsoCpu(), processo.getUsoMemoria(), sqlDate ,processo.getNome());

        System.out.println("Processos atualizado com sucesso!");
    }

}

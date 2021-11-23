/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.mapper;

import br.com.wasd.wasd.prototipo.java.model.DiscoMaquina;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author byumi
 */
public class DiscoMapper implements RowMapper<DiscoMaquina> {
    
    @Override
    public DiscoMaquina mapRow(ResultSet rs, int rowNum) throws SQLException {
        DiscoMaquina disco = new DiscoMaquina();

        disco.setDisco_id(rs.getInt("disco_id"));
        disco.setMaquina_id(rs.getInt("fk_maquina"));
        disco.setNome_disco(rs.getString("nome"));
        disco.setVolume_disco(rs.getDouble("volume"));
        
        return disco;
    }   
}

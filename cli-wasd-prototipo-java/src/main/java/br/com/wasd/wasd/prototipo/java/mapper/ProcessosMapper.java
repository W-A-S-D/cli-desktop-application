/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.mapper;

import br.com.wasd.wasd.prototipo.java.model.Processos;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author byumi
 */
public class ProcessosMapper implements RowMapper<Processos> {
    
    @Override
    public Processos mapRow(ResultSet rs, int rowNum) throws SQLException {
        Processos processo = new Processos();
        
        processo.setProcessos_id(rs.getInt("processo_id"));
        processo.setFk_maquina(rs.getInt("fk_maquina"));
        processo.setNome(rs.getString("nome"));
        processo.setUsoCpu(rs.getDouble("usoCpu"));
        processo.setUsoMemoria(rs.getDouble("usoMemoria"));
        processo.setIniciado(rs.getString("iniciado"));    
        processo.setAtualizado(rs.getString("atualizado"));    

        return processo;
    }   
}

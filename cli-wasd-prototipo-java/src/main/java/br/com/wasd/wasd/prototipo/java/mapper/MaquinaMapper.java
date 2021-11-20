package br.com.wasd.wasd.prototipo.java.mapper;

import br.com.wasd.wasd.prototipo.java.model.Maquina;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 *
 * @author manocchio
 */
public class MaquinaMapper implements RowMapper<Maquina> {

    @Override
    public Maquina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Maquina maquina = new Maquina();
        
        maquina.setMaquina_id(rs.getInt("maquina_id"));
        maquina.setFk_setor(rs.getInt("fk_setor"));
        maquina.setNome(rs.getString("nome"));
        maquina.setSo(rs.getString("so"));
        maquina.setCpu(rs.getString("cpu"));
        maquina.setRam(rs.getDouble("ram"));
        maquina.setGpu(rs.getString("gpu"));
        maquina.setStatus(rs.getString("status"));
        

        return maquina;
    }
}

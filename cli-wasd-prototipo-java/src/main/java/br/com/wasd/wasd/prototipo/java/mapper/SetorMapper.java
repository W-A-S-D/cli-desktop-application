package br.com.wasd.wasd.prototipo.java.mapper;

import br.com.wasd.wasd.prototipo.java.model.Setor;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SetorMapper implements RowMapper<Setor> {
    
    @Override
    public Setor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Setor setor = new Setor();

        setor.setSetor_id(rs.getInt("setor_id"));
        setor.setFk_usuario(rs.getInt("fk_usuario"));
        setor.setJogo(rs.getString("jogo"));
        setor.setAvatar_jogo(rs.getString("avatar_jogo"));
        
        return setor;
    }   
}

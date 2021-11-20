package br.com.wasd.wasd.prototipo.java.mapper;

import br.com.wasd.wasd.prototipo.java.model.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setUsuario_id(rs.getInt("usuario_id"));
        usuario.setFk_empresa(rs.getInt("fk_empresa"));
        usuario.setNome(rs.getString("nome"));
        usuario.setLogin(rs.getString("email"));
        usuario.setSenha(rs.getString("senha"));
        usuario.setNivelAcesso(rs.getInt("nivelAcesso"));
        usuario.setAvatar(rs.getString("avatar"));
        usuario.setCriado(rs.getString("criado"));
        usuario.setAtualizado(rs.getString("atualizado"));

        return usuario;
    }    
}

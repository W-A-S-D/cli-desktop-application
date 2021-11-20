
package br.com.wasd.wasd.prototipo.java.mapper;

import br.com.wasd.wasd.prototipo.java.model.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PedidoMapper implements RowMapper<Pedido> {

    @Override
    public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pedido pedido = new Pedido();
        
        pedido.setPedido_id(rs.getInt("pedido_id"));
        pedido.setHostname(rs.getString("hostname"));
        pedido.setStatus(rs.getInt("status"));
        pedido.setFk_usuario(rs.getInt("fk_usuario"));
        
        return pedido;
    }
}

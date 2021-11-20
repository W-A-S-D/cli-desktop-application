/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model.dao;

import br.com.wasd.wasd.prototipo.java.mapper.PedidoMapper;
import br.com.wasd.wasd.prototipo.java.model.Pedido;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

public class PedidoDao extends DAOConnection implements DAO {

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findOne(String param) {
        String sql = "select * from pedido where hostname = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{param}, new PedidoMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void insert(Object object) {
        String sql = "insert into pedido(hostname, status, fk_usuario) values ( ?, ?, ?)";
        Pedido pedido = (Pedido) object;

        jdbcTemplate.update(sql, pedido.getHostname(), pedido.getStatus(), pedido.getFk_usuario());

        System.out.println("pedido inserido com sucesso");
    }

    @Override
    public void update(Object object) {
        String sql = "UPDATE pedido SET status=? WHERE hostname = ?";
        Pedido pedido = (Pedido) object;
        jdbcTemplate.update(sql, pedido.getStatus(), pedido.getHostname());
        
        System.out.println("pedido atualizado com sucesso!");
    }

}

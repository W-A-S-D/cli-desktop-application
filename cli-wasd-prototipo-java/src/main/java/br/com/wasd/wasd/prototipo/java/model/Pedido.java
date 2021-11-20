/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model;

public class Pedido {
    Integer pedido_id;
    String hostname;
    Integer status;
    Integer fk_usuario;

    public Pedido() {
    }

    public Pedido(String hostname, Integer status, Integer fk_usuario) {
        this.hostname = hostname;
        this.status = status;
        this.fk_usuario = fk_usuario;
    }
    
    
    public Integer getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Integer pedido_id) {
        this.pedido_id = pedido_id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(Integer fk_usuario) {
        this.fk_usuario = fk_usuario;
    }
    
    
}

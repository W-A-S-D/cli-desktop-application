/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model;

/**
 *
 * @author byumi
 */
public class DiscoMaquina {

    private Integer disco_id;
    private Integer maquina_id;
    private String nome_disco;
    private Double volume_disco;

    public DiscoMaquina(Integer maquina_id, String nome_disco, Double volume_disco) {
        this.maquina_id = maquina_id;
        this.nome_disco = nome_disco;
        this.volume_disco = volume_disco;
    }

    public DiscoMaquina() {
    }

    
    public Integer getDisco_id() {
        return disco_id;
    }

    public void setDisco_id(Integer disco_id) {
        this.disco_id = disco_id;
    }

    public Integer getMaquina_id() {
        return maquina_id;
    }

    public void setMaquina_id(Integer maquina_id) {
        this.maquina_id = maquina_id;
    }

    public String getNome_disco() {
        return nome_disco;
    }

    public void setNome_disco(String nome_disco) {
        this.nome_disco = nome_disco;
    }

    public Double getVolume_disco() {
        return volume_disco;
    }

    public void setVolume_disco(Double volume_disco) {
        this.volume_disco = volume_disco;
    }

}

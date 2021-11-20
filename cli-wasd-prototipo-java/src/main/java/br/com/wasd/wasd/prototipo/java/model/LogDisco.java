/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model;

/**
 *
 * @author Wesley
 */
public class LogDisco {
    private Integer fk_log;
    private Integer fk_disco;
    private Double uso_disco;

    public LogDisco(Integer fk_log, Integer fk_disco, Double uso_disco) {
        this.fk_log = fk_log;
        this.fk_disco = fk_disco;
        this.uso_disco = uso_disco;
    }

    public Integer getFk_log() {
        return fk_log;
    }

    public void setFk_log(Integer fk_log) {
        this.fk_log = fk_log;
    }

    public Integer getFk_disco() {
        return fk_disco;
    }

    public void setFk_disco(Integer fk_disco) {
        this.fk_disco = fk_disco;
    }

    public Double getUso_disco() {
        return uso_disco;
    }

    public void setUso_disco(Double uso_disco) {
        this.uso_disco = uso_disco;
    }
    
    
}

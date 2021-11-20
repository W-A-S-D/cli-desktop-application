/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java.model;

import java.time.LocalDateTime;

/**
 *
 * @author ELIZEULUISSOUZA
 */
public class Log {
    private Integer log_id;
    private Integer fk_maquina;
    private Double  freq_cpu;
    private Double  uso_ram;
    private Double  uso_disco;
    private Double  temperatura;
    private LocalDateTime  criado;

    public Log(Integer fk_maquina, Double freq_cpu, Double uso_ram, Double uso_disco, Double temperatura) {
        this.fk_maquina = fk_maquina;
        this.freq_cpu = freq_cpu;
        this.uso_ram = uso_ram;
        this.uso_disco = uso_disco;
        this.temperatura = temperatura;
        criado = LocalDateTime.now();
    }
    
    

    public Integer getLog_id() {
        return log_id;
    }

    public void setLog_id(Integer log_id) {
        this.log_id = log_id;
    }

    public Integer getFk_maquina() {
        return fk_maquina;
    }

    public void setFk_maquina(Integer fk_maquina) {
        this.fk_maquina = fk_maquina;
    }

    public Double getFreq_cpu() {
        return freq_cpu;
    }

    public void setFreq_cpu(Double freq_cpu) {
        this.freq_cpu = freq_cpu;
    }

    public Double getUso_ram() {
        return uso_ram;
    }

    public void setUso_ram(Double uso_ram) {
        this.uso_ram = uso_ram;
    }

    public Double getUso_disco() {
        return uso_disco;
    }

    public void setUso_disco(Double uso_disco) {
        this.uso_disco = uso_disco;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public LocalDateTime getCriado() {
        return criado;
    }

    public void setCriado(LocalDateTime criado) {
        this.criado = criado;
    }       
}

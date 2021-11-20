package br.com.wasd.wasd.prototipo.java.model;

public class Processos {

    private Integer processos_id;
    private Integer fk_maquina;
    private String nome;
    private Double usoCpu;
    private Double usoMemoria;
    private String iniciado;
    private String atualizado;

    
    public Double getUsoCpu() {
        return usoCpu;
    }

    public void setUsoCpu(Double usoCpu) {
        this.usoCpu = usoCpu;
    }

    public Double getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(Double usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    public String getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(String atualizado) {
        this.atualizado = atualizado;
    }

    
    public Integer getProcessos_id() {
        return processos_id;
    }

    public void setProcessos_id(Integer processos_id) {
        this.processos_id = processos_id;
    }

    public Integer getFk_maquina() {
        return fk_maquina;
    }

    public void setFk_maquina(Integer fk_maquina) {
        this.fk_maquina = fk_maquina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIniciado() {
        return iniciado;
    }

    public void setIniciado(String iniciado) {
        this.iniciado = iniciado;
    }


}

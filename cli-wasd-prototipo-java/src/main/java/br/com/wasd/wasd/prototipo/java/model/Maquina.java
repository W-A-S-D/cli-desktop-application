package br.com.wasd.wasd.prototipo.java.model;

public class Maquina {

    private Integer maquina_id;
    private Integer fk_setor;
    private String nome;
    private String so;
    private String cpu;
    private Double ram;
    private String gpu;
    private String status;

    public Maquina(){}
        
    public Maquina(Integer maquina_id, String nome, String so, String cpu, Double ram, String gpu, String status) {
        this.maquina_id = maquina_id;
        this.nome = nome;
        this.so = so;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = "";
        this.status = status;
    }

  
    public Maquina(Integer maquina_id, String nome, String so, String cpu, Double ram, String status) {
        this.maquina_id = maquina_id;
        this.nome = nome;
        this.so = so;
        this.cpu = cpu;
        this.ram = ram;
        this.status = status;
    }

    public Maquina(String nome, String so, String cpu, Double ram, String gpu, String status) {
        this.nome = nome;
        this.so = so;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
        this.status = status;
    }

    public Maquina(String nome, String so, String cpu, Double ram, String status) {
        this.nome = nome;
        this.so = so;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = "";
        this.status = status;
    }
    
    
    
    
    public Integer getMaquina_id() {
        return maquina_id;
    }

    public void setMaquina_id(Integer maquina_id) {
        this.maquina_id = maquina_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Double getRam() {
        return ram;
    }

    public void setRam(Double ram) {
        this.ram = ram;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFk_setor() {
        return fk_setor;
    }

    public void setFk_setor(Integer fk_setor) {
        this.fk_setor = fk_setor;
    }


}
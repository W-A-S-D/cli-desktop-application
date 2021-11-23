package br.com.wasd.wasd.prototipo.java.model;

public class Setor {
    Integer setor_id;          
    Integer fk_usuario;
    String jogo;
    String avatar_jogo;

    public Setor(){}

    public Integer getSetor_id() {
        return setor_id;
    }
    public void setSetor_id(Integer setor_id) {
        this.setor_id = setor_id;
    }
    public Integer getFk_usuario() {
        return fk_usuario;
    }
    public void setFk_usuario(Integer fk_usuario) {
        this.fk_usuario = fk_usuario;
    }
    public String getJogo() {
        return jogo;
    }
    public void setJogo(String jogo) {
        this.jogo = jogo;
    }
    public String getAvatar_jogo() {
        return avatar_jogo;
    }
    public void setAvatar_jogo(String avatar_jogo) {
        this.avatar_jogo = avatar_jogo;
    }
    
}

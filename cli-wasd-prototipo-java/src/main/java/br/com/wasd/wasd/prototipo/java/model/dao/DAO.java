package br.com.wasd.wasd.prototipo.java.model.dao;

import java.util.List;

public interface DAO {

    public List findAll();
    public Object findOne(String param);
    public void insert(Object object);
    public void update(Object object);

}

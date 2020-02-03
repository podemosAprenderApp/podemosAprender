package repositories;

import entities.usuarios.Usuario;
import repositories.daos.DAO;

import java.util.List;

public class Repositorio {
    private DAO dao;

    public Repositorio(DAO dao){
        this.dao = dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public void agregar(Object unObjeto){
        this.dao.agregar(unObjeto);
    }

    public void modificar(Object unObjeto){
        this.dao.modificar(unObjeto);
    }

    public void eliminar(Object unObjeto){
        this.dao.eliminar(unObjeto);
    }

    public <T> List<T> buscarTodos(Class<T> clazz){
        return this.dao.buscarTodos(clazz);
    }

    public <T> T buscar(int id, Class<T> clazz) { return this.dao.buscar(id, clazz);}
}

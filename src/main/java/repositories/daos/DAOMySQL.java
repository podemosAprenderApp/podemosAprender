package repositories.daos;

import java.util.List;

import static db.EntityManagerHelper.entityManager;
import static db.EntityManagerHelper.withTransaction;

public class DAOMySQL implements DAO {

    public DAOMySQL(){

    }

    public <T> List<T> buscarTodos(Class<T> clazz) {
        return entityManager().createQuery("from ".concat(clazz.getSimpleName())).getResultList();
    }

    @Override
    public <T> T buscar(int id, Class<T> clazz) {
        return (T) entityManager().createQuery("from ".concat(clazz.getSimpleName())
                .concat(" where id = ").concat(String.valueOf(id)))
                .getSingleResult();
    }

    public void agregar(Object object){
        withTransaction(() -> {
            entityManager().persist(object);
        });
    }

    public void modificar(Object object){
        withTransaction(() -> {
            entityManager().merge(object);
        });
    }

    public void eliminar(Object object){
        withTransaction(() -> {
            entityManager().remove(object);
        });
    }
}
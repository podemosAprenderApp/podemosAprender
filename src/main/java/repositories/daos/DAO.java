package repositories.daos;

import java.util.List;

public interface DAO {
    public <T> List<T> buscarTodos(Class<T> clazz);
    public <T> T buscar(int id, Class<T> clazz);
    public <T> void agregar(T unObjeto);
    public <T> void modificar(T unObjeto);
    public <T> void eliminar(T unObjeto);
}
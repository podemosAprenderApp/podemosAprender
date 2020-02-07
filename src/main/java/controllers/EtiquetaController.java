package controllers;

import entities.membresia.Etiqueta;
import entities.membresia.Membresia;
import entities.usuarios.Usuario;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import javax.persistence.NoResultException;
import java.util.List;

public class EtiquetaController extends Controller {
    public EtiquetaController(Repositorio repo) {
        super(repo);
    }

    public List<Etiqueta> buscarTodos(Request request, Response response){
        return repo.buscarTodos(Etiqueta.class);
    }

    public Etiqueta buscar(Request request, Response response)
    {
        return super.buscar(request, response, Etiqueta.class);
    }

    public Etiqueta buscarPorMembresia(Request request, Response response) {
        Integer idMembresia = Integer.parseInt(request.params("idMembresia"));
        Integer id = Integer.parseInt(request.params("id"));
        Membresia membresia = repo.buscar(idMembresia, Membresia.class);
        Etiqueta etiqueta = membresia.getEtiquetas().stream().filter(p -> id.equals(p.getId())).findFirst().orElseThrow(NoResultException::new);
        return etiqueta;
    }

    public List<Etiqueta> buscarTodosPorMembresia(Request request, Response response) {
        Integer idMembresia = Integer.parseInt(request.params("idMembresia"));
        Membresia membresia = repo.buscar(idMembresia, Membresia.class);
        return membresia.getEtiquetas();
    }
}

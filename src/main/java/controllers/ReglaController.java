package controllers;

import entities.banda.Banda;
import entities.banda.Regla;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import javax.persistence.NoResultException;
import java.util.List;

public class ReglaController extends Controller {
    public ReglaController(Repositorio repo) {
        super(repo);
    }

    public List<Regla> buscarTodos(Request request, Response response){
        return repo.buscarTodos(Regla.class);
    }

    public Regla buscar(Request request, Response response)
    {
        return super.buscar(request, response, Regla.class);
    }

    public Regla buscarPorBanda(Request request, Response response) {
        Integer idBanda = Integer.parseInt(request.params("idBanda"));
        Integer id = Integer.parseInt(request.params("id"));
        Banda banda = repo.buscar(idBanda, Banda.class);
        Regla regla = banda.getReglas().stream().filter(p -> id.equals(p.getId())).findFirst().orElseThrow(NoResultException::new);
        return regla;
    }

    public List<Regla> buscarTodosPorBanda(Request request, Response response) {
        Integer idBanda = Integer.parseInt(request.params("idBanda"));
        Banda banda = repo.buscar(idBanda, Banda.class);
        return banda.getReglas();
    }
}

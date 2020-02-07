package controllers;

import entities.banda.Banda;
import entities.banda.eventos.Evento;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import javax.persistence.NoResultException;
import java.util.List;

public class EventoController extends Controller {
    public EventoController(Repositorio repo) {
        super(repo);
    }

    public List<Evento> buscarTodos(Request request, Response response){
        return repo.buscarTodos(Evento.class);
    }

    public Evento buscar(Request request, Response response)
    {
        return super.buscar(request, response, Evento.class);
    }

    public Evento buscarPorBanda(Request request, Response response) {
        Integer idBanda = Integer.parseInt(request.params("idBanda"));
        Integer id = Integer.parseInt(request.params("id"));
        Banda banda = repo.buscar(idBanda, Banda.class);
        Evento evento = banda.getEventos().stream().filter(p -> id.equals(p.getId())).findFirst().orElseThrow(NoResultException::new);
        return evento;
    }

    public List<Evento> buscarTodosPorBanda(Request request, Response response) {
        Integer idBanda = Integer.parseInt(request.params("idBanda"));
        Banda banda = repo.buscar(idBanda, Banda.class);
        return banda.getEventos();
    }
}

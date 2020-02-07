package controllers;

import entities.banda.Banda;
import entities.banda.eventos.Evento;
import entities.banda.eventos.invitaciones.Invitacion;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import javax.persistence.NoResultException;
import java.util.List;

public class InvitacionController extends Controller{
    public InvitacionController(Repositorio repo) {
        super(repo);
    }

    public List<Invitacion> buscarTodos(Request request, Response response){
        return repo.buscarTodos(Invitacion.class);
    }

    public Invitacion buscar(Request request, Response response)
    {
        return super.buscar(request, response, Invitacion.class);
    }

    public Invitacion buscarPorEvento(Request request, Response response) {
        Integer idEvento = Integer.parseInt(request.params("idEvento"));
        Integer id = Integer.parseInt(request.params("id"));
        Evento evento = repo.buscar(idEvento, Evento.class);
        Invitacion invitacion = evento.getInvitaciones().stream().filter(p -> id.equals(p.getId())).findFirst().orElseThrow(NoResultException::new);
        return invitacion;
    }

    public List<Invitacion> buscarTodosPorEvento(Request request, Response response) {
        Integer idEvento = Integer.parseInt(request.params("idEvento"));
        Evento evento = repo.buscar(idEvento, Evento.class);
        return evento.getInvitaciones();
    }
}

package controllers;

import entities.banda.Banda;
import entities.banda.Pregunta;
import entities.usuarios.reaccionables.rasgos.Topico;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class PreguntaController extends Controller {
    public PreguntaController(Repositorio repo) {
        super(repo);
    }

    public List<Pregunta> buscarTodos(Request request, Response response){
        return repo.buscarTodos(Pregunta.class);
    }

    public Pregunta buscar(Request request, Response response)
    {
        return super.buscar(request, response, Pregunta.class);
    }

    public Pregunta buscarPorBanda(Request request, Response response) {
        Integer idBanda = Integer.parseInt(request.params("idBanda"));
        Integer id = Integer.parseInt(request.params("id"));
        Banda banda = repo.buscar(idBanda, Banda.class);
        Pregunta pregunta = banda.getPreguntas().stream().filter(p -> id.equals(p.getId())).findFirst().orElseThrow(NoResultException::new);
        return pregunta;
    }

    public List<Pregunta> buscarTodosPorBanda(Request request, Response response) {
        Integer idBanda = Integer.parseInt(request.params("idBanda"));
        Banda banda = repo.buscar(idBanda, Banda.class);
        return banda.getPreguntas();
    }
}

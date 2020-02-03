package controllers;

import entities.usuarios.Usuario;
import entities.usuarios.reaccionables.rasgos.Topico;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import java.util.List;

public class TopicoController extends Controller {
    public TopicoController(Repositorio repo) {
        super(repo);
    }


    public List<Topico> buscarTodos(Request request, Response response){
        return repo.buscarTodos(Topico.class);
    }

    public Topico buscar(Request request, Response response)
    {
        return super.buscar(request, response, Topico.class);
    }

}

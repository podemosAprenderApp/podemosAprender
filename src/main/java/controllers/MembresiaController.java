package controllers;

import entities.membresia.Membresia;
import entities.usuarios.Usuario;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import java.util.List;

public class MembresiaController extends Controller {
    public MembresiaController(Repositorio repo) {
        super(repo);
    }

    public List<Membresia> buscarTodos(Request request, Response response){
        return repo.buscarTodos(Membresia.class);
    }

    public Membresia buscar(Request request, Response response)
    {
        return super.buscar(request, response, Membresia.class);
    }

}

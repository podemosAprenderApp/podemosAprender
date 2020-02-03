package controllers;

import entities.usuarios.Usuario;
import entities.usuarios.reaccionables.rasgos.Rasgo;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import java.util.List;

import static converters.JsonConverter.fromJson;
import static db.EntityManagerHelper.*;

public class RasgoController extends Controller {

    public RasgoController(Repositorio repo) {
        super(repo);
    }

    public List<Rasgo> buscarTodos(Request request, Response response){
        return repo.buscarTodos(Rasgo.class);
    }


    public Rasgo buscar(Request request, Response response)
    {
        return super.buscar(request, response, Rasgo.class);
    }

    public List<Rasgo> buscarTodosPorUsuario(Request request, Response response){
        int idUsuario = Integer.parseInt(request.params("idUsuario"));
        Usuario usuario = repo.buscar(idUsuario, Usuario.class);
        return usuario.getRasgos();
    }

    public Response agregar(Request request, Response response) {
        int idUser = Integer.parseInt(request.params(":id"));
        Usuario usuario = repo.buscar(idUser, Usuario.class);
        Rasgo rasgo = fromJson(request.body(), Rasgo.class);
        usuario.agregar(rasgo);
        withTransaction(()->{{
            persist(rasgo);
            usuario.agregar(rasgo);
        }});
        response.redirect("/");
        return response;
    }

    public Response eliminar(Request request, Response response){
        Usuario usuario = fromJson(request.body(), Usuario.class);
        repo.eliminar(usuario);
        response.redirect("/");
        return response;
    }

    public Response modificar(Request request, Response response){
        Usuario usuario = fromJson(request.body(), Usuario.class);
        repo.modificar(usuario);
        response.redirect("/");
        return response;
    }
}

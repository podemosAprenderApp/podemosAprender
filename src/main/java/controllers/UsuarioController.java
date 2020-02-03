package controllers;

import entities.usuarios.Usuario;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

import static converters.JsonConverter.*;

public class UsuarioController extends Controller{

    public UsuarioController(Repositorio repo){
        super(repo);
    }

    public List<Usuario> buscarTodos(Request request, Response response){
        return repo.buscarTodos(Usuario.class);
    }

    public Usuario buscar(Request request, Response response)
    {
        return super.buscar(request, response, Usuario.class);
    }

    public Response agregar(Request request, Response response) {
        Usuario usuario = fromJson(request.body(), Usuario.class);
        repo.agregar(usuario);
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

package controllers;

import entities.banda.Banda;
import entities.usuarios.Usuario;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import javax.persistence.NoResultException;
import java.util.List;

import static converters.JsonConverter.fromJson;

public class BandaController extends Controller{

    public BandaController(Repositorio repo){
        super(repo);
    }

    public List<Banda> buscarTodos(Request request, Response response){
        return this.repo.buscarTodos(Banda.class);
    }

    public Banda buscar(Request request, Response response){
        return super.buscar(request, response, Banda.class);
    }

    public Response agregar(Request request, Response response) {
        Banda banda = fromJson(request.body(), Banda.class);
        repo.agregar(banda);
        response.redirect("/");
        return response;
    }

    public Response eliminar(Request request, Response response){
        Banda banda = fromJson(request.body(), Banda.class);
        repo.eliminar(banda);
        response.redirect("/");
        return response;
    }

    public Response modificar(Request request, Response response){
        Banda banda = fromJson(request.body(), Banda.class);
        repo.modificar(banda);
        response.redirect("/");
        return response;
    }
}

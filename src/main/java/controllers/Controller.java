package controllers;

import entities.banda.Banda;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import javax.persistence.NoResultException;

public class Controller {
    Repositorio repo;
    public Controller(Repositorio repo){
        this.repo = repo;
    }

    public <T> T buscar(Request request, Response response, Class<T> clazz){
        int id = Integer.parseInt(request.params(":id"));
        return this.repo.buscar(id, clazz);
    }
}

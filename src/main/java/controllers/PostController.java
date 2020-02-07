package controllers;

import entities.banda.Banda;
import entities.usuarios.reaccionables.Post;
import repositories.Repositorio;
import spark.Request;
import spark.Response;

import javax.persistence.NoResultException;
import java.util.List;

public class PostController extends Controller{
    public PostController(Repositorio repo) {
        super(repo);
    }

    public List<Post> buscarTodos(Request request, Response response){
        return repo.buscarTodos(Post.class);
    }

    public Post buscar(Request request, Response response)
    {
        return super.buscar(request, response, Post.class);
    }

    public Post buscarPorBanda(Request request, Response response) {
        int idBanda = Integer.parseInt(request.params("idBanda"));
        Integer id = Integer.parseInt(request.params("id"));
        Banda banda = repo.buscar(idBanda, Banda.class);
        return banda.getPosts().stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst()
                .orElseThrow(NoResultException::new);
    }

    public List<Post> buscarTodosPorBanda(Request request, Response response) {
        int idBanda = Integer.parseInt(request.params("idBanda"));
        Banda banda = repo.buscar(idBanda, Banda.class);
        return banda.getPosts();
    }
}

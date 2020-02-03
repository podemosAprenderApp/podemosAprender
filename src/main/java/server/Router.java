package server;

import controllers.*;
import repositories.Repositorio;
import repositories.daos.DAOMySQL;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utils.BooleanHelper;
import utils.HandlebarsTemplateEngineBuilder;

import javax.persistence.NoResultException;

import static converters.JsonConverter.toJson;
import static spark.Spark.*;

class Router {
    private static Repositorio repo;
    private static HandlebarsTemplateEngine engine;

    private static void initEngine(){
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    private static void setRepo(Repositorio repo){
        Router.repo = repo;
    }

    static void init(){
        initEngine();
        staticFileLocation("/public");
        setRepo(new Repositorio(new DAOMySQL()));
        Router.setRoutes();
    }

    private static void setRoutes(){
        setPages();
        path("/api", () -> {
            before((request, response) -> {{
                response.header("encoding","UTF8");
            }});
            setUsuario();
            setBanda();
            setRasgo();
            setTopico();
            after((request, response) -> {
                response.header("Content-Encoding", "gzip");
            });
        });
    }

    private static void setUsuario(){
        final UsuarioController usuarios = new UsuarioController(repo);
        before((request, response) -> response.type("application/json"));
        get("/usuarios", usuarios::buscarTodos, toJson());
        get("/usuario/:id", usuarios::buscar, toJson());
        post("/usuario", usuarios::agregar);
        put("/usuario/:id", usuarios::modificar);
        delete("/usuario/:id" , usuarios::eliminar);
    }

    private static void setPages(){
        final PagesController pages = new PagesController();
        before((request, response) -> response.type("text/html"));
        exception(NoResultException.class, pages::notFound);
        get("/", pages::home, engine);
    }

    private static void setBanda(){
        final BandaController bandas = new BandaController(repo);
        before((request, response) -> response.type("application/json"));
        get("/bandas", bandas::buscarTodos, toJson());
        get("/banda/:id", bandas::buscar, toJson());
        post("/banda", bandas::agregar);
        put("/banda/:id", bandas::modificar);
        delete("/banda/:id" , bandas::eliminar);
    }

    public static void setRasgo(){
        final RasgoController rasgos = new RasgoController(repo);
        before((request, response) -> response.type("application/json"));
        get("/rasgos", rasgos::buscarTodos, toJson());
        get("/rasgo/:id",rasgos::buscar, toJson());
    }

    public static void setTopico(){
        final TopicoController topicos = new TopicoController((repo));
        before((request, response) -> response.type("application/json"));
        get("/topicos", topicos::buscarTodos, toJson());
        get("/topico/:id",topicos::buscar, toJson());
    }
}

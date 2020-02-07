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
            before((request, response) -> response.header("Accept-Charset", "UTF-8"));
            setRasgo();
            setUsuario();
            setBanda();
            setTopico();
            setMembresia();
            setPregunta();
            setReglas();
            setEventos();
            setInvitaciones();
            setEtiquetas();
            setPosts();
            after((request, response) -> response.header("Content-Encoding", "gzip"));
        });
    }

    private static void setPosts() {
        final PostController posts = new PostController(repo);
        before((request, response) -> response.type("application/json; charset=utf-8"));
        get("/posts", posts::buscarTodos, toJson());
        get("/post/id", posts::buscar, toJson());
        get("/banda/:idBanda/posts", posts::buscarTodosPorBanda, toJson());
        get( "/banda/:idBanda/post/:id", posts::buscarPorBanda, toJson());
    }

    private static void setEtiquetas() {
        final EtiquetaController eitquetas = new EtiquetaController(repo);
        before((request, response) -> response.type("application/json; charset=utf-8"));
        get("/etiquetas", eitquetas::buscarTodos, toJson());
        get("/etiqueta/:id", eitquetas::buscar, toJson());
        get("/membresia/:idMembresia/etiquetas", eitquetas::buscarTodosPorMembresia, toJson());
        get( "/membresia/:idMembresia/etiqueta/:id", eitquetas::buscarPorMembresia, toJson());
    }

    private static void setInvitaciones() {
        final InvitacionController invitaciones = new InvitacionController(repo);
        before((request, response) -> response.type("application/json; charset=utf-8"));
        get("/invitaciones", invitaciones::buscarTodos, toJson());
        get("/invitacion/:id", invitaciones::buscar, toJson());
        get("/evento/:idEvento/invitaciones", invitaciones::buscarTodosPorEvento, toJson());
        get( "/evento/:idEvento/invitacion/:id", invitaciones::buscarPorEvento, toJson());
    }

    private static void setEventos() {
        final EventoController eventos = new EventoController(repo);
        before((request, response) -> response.type("application/json; charset=utf-8"));
        get("/evento", eventos::buscarTodos, toJson());
        get("/evento/:id", eventos::buscar, toJson());
        get("/banda/:idBanda/eventos", eventos::buscarTodosPorBanda, toJson());
        get( "/banda/:idBanda/evento/:id", eventos::buscarPorBanda, toJson());
    }

    private static void setReglas() {
        final ReglaController reglas = new ReglaController(repo);
        before((request, response) -> response.type("application/json; charset=utf-8"));
        get("/reglas", reglas::buscarTodos, toJson());
        get("/regla/:id", reglas::buscar, toJson());
        get("/banda/:idBanda/reglas", reglas::buscarTodosPorBanda, toJson());
        get( "/banda/:idBanda/regla/:id", reglas::buscarPorBanda, toJson());
    }

    private static void setUsuario(){
        final UsuarioController usuarios = new UsuarioController(repo);
        before((request, response) -> response.type("application/json; charset=utf-8"));
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

    private static void setRasgo(){
        final RasgoController rasgos = new RasgoController(repo);
        before((request, response) -> response.type("application/json"));
        get("/rasgos", rasgos::buscarTodos, toJson());
        get("/rasgo/:id", rasgos::buscar, toJson());
        get("/usuario/:idUsuario/rasgos", rasgos::buscarTodosPorUsuario, toJson());
        get("/usuario/:idUsuario/rasgo/:id",rasgos::buscarPorUsuario, toJson());
        get("/usuario/:idUsuario/rasgovalidable/:id",rasgos::buscarValidable, toJson());
        get("/usuario/:idUsuario/rasgosvalidables",rasgos::buscarValidables, toJson());

    }

    private static void setTopico(){
        final TopicoController topicos = new TopicoController((repo));
        before((request, response) -> response.type("application/json"));
        get("/topicos", topicos::buscarTodos, toJson());
        get("/topico/:id",topicos::buscar, toJson());
    }

    private static void setMembresia(){
        final MembresiaController membresias = new MembresiaController(repo);
        before((request, response) -> response.type("application/json"));
        get("/membresias", membresias::buscarTodos, toJson());
        get("/membresia/:id",membresias::buscar, toJson());
    }

    private static void setPregunta(){
        final PreguntaController preguntas = new PreguntaController(repo);
        before((request, response) -> response.type("application/json"));
        get("/preguntas", preguntas::buscarTodos, toJson());
        get("/pregunta/:id", preguntas::buscar, toJson());
        get("/banda/:idBanda/pregunta/:id", preguntas::buscarPorBanda, toJson());
        get("/banda/:idBanda/preguntas", preguntas::buscarTodosPorBanda, toJson());
    }
}

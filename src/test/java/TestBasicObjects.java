import entities.banda.Banda;
import entities.banda.Pregunta;
import entities.banda.Regla;
import entities.banda.eventos.Evento;
import entities.banda.eventos.visibilidades.Publico;
import entities.membresia.Etiqueta;
import entities.membresia.Membresia;
import entities.membresia.Respuesta;
import entities.membresia.estados.Aprobado;
import entities.membresia.estados.EstadoMembresia;
import entities.permisos.Admin;
import entities.permisos.Miembro;
import entities.permisos.Rol;
import entities.usuarios.Usuario;
import entities.usuarios.reaccionables.Post;
import entities.usuarios.reaccionables.Reaccion;
import entities.usuarios.reaccionables.TipoReaccion;
import entities.usuarios.reaccionables.rasgos.*;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestBasicObjects {
    Expertise expertise;
    TipoExpertise tipoExpertise;
    Rasgo rasgo;
    Rol adm, user;
    RasgoValidable rasgoValidable;
    Usuario jorge, tobias;
    TipoReaccion meDivierte, meEnoja;
    Reaccion reaccionEnojada, reaccionDeJorge;
    Puntuacion puntuacion;
    Topico dev, venderGall;
    Comentario comentario, respuesta;
    Regla serAmable, traerPC;
    Pregunta cualEsTuAnimal;
    Usuario dario, noe, lean, mercedes, dani, pipi;
    Membresia memDaro, memNoe, memLean, memMer, memDani, memPipi;
    EstadoMembresia aprobado;
    Evento evento;
    Banda bandaPodemosAprender;
    Respuesta miAnimalFavorito1, miAnimalFavorito2, miAnimalFavorito3, miAnimalFavorito4, miAnimalFavorito5
            , miAnimalFavorito6;
    Etiqueta cocinero;
    Post post;

    @BeforeEach
    public void init() {
        evento = new Evento(LocalDateTime.now(), "Juntada Loca", "Vamos a codear a lo loco",
                new ArrayList<>(), "Grand View Hotel (maps)", new Publico());
        cocinero = new Etiqueta("Cocinero");
        comentario = new Comentario(LocalDateTime.now(), "Que tipazo");
        respuesta = new Comentario(LocalDateTime.now(), "Gracias che");
        tipoExpertise = new TipoExpertise("Experto");
        dev = new Topico("Desarrollo en Java");
        venderGall = new Topico("Vender galletitas");
        expertise = new Expertise(tipoExpertise, new ArrayList<>());
        rasgo = new Interes(dev, LocalDateTime.now(), new ArrayList<>());
        rasgoValidable = new Habilidad(venderGall, expertise, LocalDateTime.now(), new ArrayList<>());
        jorge = new Usuario(LocalDateTime.now(), new ArrayList<Rasgo>() {{
            add(rasgo);
        }},
                "Jorge", "jorgecapo", "estoNoEsUnHash");
        post = new Post("Hice una bocha y te lo cuento (T!)", new ArrayList<>(), jorge);

        tobias = new Usuario(LocalDateTime.now(), new ArrayList<Rasgo>() {{
            add(rasgoValidable);
        }},
                "Tobias", "tobiascapo", "estoNoEsUnHash");
        user = new Miembro();
        adm = new Admin();
        meDivierte = new TipoReaccion("Me Divierte");
        meEnoja = new TipoReaccion("Me Enoja");
        reaccionEnojada = new Reaccion(meEnoja, jorge);
        reaccionDeJorge = new Reaccion(meDivierte, jorge);
        puntuacion = new Puntuacion(true, comentario, respuesta
                , jorge);
        serAmable = new Regla("Ser amable");
        traerPC = new Regla("Traer PC");
        aprobado = new Aprobado(LocalDateTime.now());
        cualEsTuAnimal = new Pregunta("Cual es tu animal favorito?", 1, LocalDateTime.now());
        miAnimalFavorito1 = new Respuesta("Perro", cualEsTuAnimal, LocalDateTime.now());
        miAnimalFavorito2 = new Respuesta("Gato", cualEsTuAnimal, LocalDateTime.now());
        miAnimalFavorito3 = new Respuesta("Jirafa", cualEsTuAnimal, LocalDateTime.now());
        miAnimalFavorito4 = new Respuesta("Caballo", cualEsTuAnimal, LocalDateTime.now());
        miAnimalFavorito5 = new Respuesta("Canario", cualEsTuAnimal, LocalDateTime.now());
        miAnimalFavorito6 = new Respuesta("Leon", cualEsTuAnimal, LocalDateTime.now());
        dario = new Usuario(LocalDateTime.now(), new ArrayList<>(), "Dario", "daro", "estoNoEsUnHash");
        noe = new Usuario(LocalDateTime.now(), new ArrayList<>(), "Noelia", "noe", "estoNoEsUnHash");
        lean = new Usuario(LocalDateTime.now(), new ArrayList<>(), "Leandro", "lean", "estoNoEsUnHash");
        mercedes = new Usuario(LocalDateTime.now(), new ArrayList<>(), "Mercedes", "mercedes", "estoNoEsUnHash");
        dani = new Usuario(LocalDateTime.now(), new ArrayList<>(), "Daniel", "dani", "estoNoEsUnHash");
        pipi = new Usuario(LocalDateTime.now(), new ArrayList<>(), "Pipi", "pipi", "estoNoEsUnHash");
        memDaro = new Membresia(dario, aprobado, new ArrayList<Respuesta>(){{add(miAnimalFavorito1);}},
                new ArrayList<>(), adm, new ArrayList<Etiqueta>(){{add(cocinero);}});
        memDani = new Membresia(dani, aprobado, new ArrayList<Respuesta>(){{add(miAnimalFavorito2);}},
                new ArrayList<>(), adm, new ArrayList<Etiqueta>(){{add(cocinero);}});
        memNoe = new Membresia(noe, aprobado, new ArrayList<Respuesta>(){{add(miAnimalFavorito3);}},
                new ArrayList<>(), adm, new ArrayList<Etiqueta>(){{add(cocinero);}});
        memLean = new Membresia(lean, aprobado, new ArrayList<Respuesta>(){{add(miAnimalFavorito4);}},
                new ArrayList<>(), adm, new ArrayList<Etiqueta>(){{add(cocinero);}});
        memMer = new Membresia(mercedes, aprobado, new ArrayList<Respuesta>(){{add(miAnimalFavorito5);}},
                new ArrayList<>(), adm, new ArrayList<Etiqueta>(){{add(cocinero);}});
        memPipi = new Membresia(pipi, aprobado, new ArrayList<Respuesta>(){{add(miAnimalFavorito6);}},
                new ArrayList<>(), adm, new ArrayList<Etiqueta>(){{add(cocinero);}});
        bandaPodemosAprender = new Banda("Podemos Aprender", "Somos la banda más loca que hay. Después de San Lorenzo."
                , new ArrayList<Regla>(){{add(serAmable); add(traerPC);}}, new ArrayList<Pregunta>(){{add(cualEsTuAnimal);}},
                new ArrayList<Membresia>(){{add(memDaro); add(memDani); add(memNoe); add(memLean); add(memMer); add(memPipi);}},
                new ArrayList<Evento>(){{add(evento);}}, new ArrayList<Post>(){{add(post);}});

    }
}

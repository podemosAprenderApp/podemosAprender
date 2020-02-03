import static db.EntityManagerHelper.*;
import org.junit.jupiter.api.Test;

public class PersistenceTest extends TestBasicObjects {
    @Test
    public void persistenciaInicial(){
        beginTransaction();

        getEntityManager().persist(serAmable);
        getEntityManager().persist(traerPC);
        getEntityManager().persist(aprobado);
        getEntityManager().persist(adm);
        getEntityManager().persist(user);
        getEntityManager().persist(dario);
        getEntityManager().persist(noe);
        getEntityManager().persist(lean);
        getEntityManager().persist(mercedes);
        getEntityManager().persist(dani);
        getEntityManager().persist(pipi);
        getEntityManager().persist(memDaro);
        getEntityManager().persist(memNoe);
        getEntityManager().persist(memLean);
        getEntityManager().persist(memMer);
        getEntityManager().persist(memDani);
        getEntityManager().persist(memPipi);
        getEntityManager().persist(venderGall);
        getEntityManager().persist(dev);
        getEntityManager().persist(evento);
        getEntityManager().persist(tipoExpertise);
        getEntityManager().persist(comentario);
        getEntityManager().persist(respuesta);
        getEntityManager().persist(expertise);
        getEntityManager().persist(rasgo);
        getEntityManager().persist(rasgoValidable);
        getEntityManager().persist(jorge);
        getEntityManager().persist(tobias);
        getEntityManager().persist(meDivierte);
        getEntityManager().persist(meEnoja);
        getEntityManager().persist(reaccionEnojada);
        getEntityManager().persist(reaccionDeJorge);
        getEntityManager().persist(puntuacion);
        getEntityManager().persist(post);
        getEntityManager().persist(cocinero);
        getEntityManager().persist(miAnimalFavorito1);
        getEntityManager().persist(miAnimalFavorito2);
        getEntityManager().persist(miAnimalFavorito3);
        getEntityManager().persist(miAnimalFavorito4);
        getEntityManager().persist(miAnimalFavorito5);
        getEntityManager().persist(miAnimalFavorito6);
        getEntityManager().persist(aprobado);
        getEntityManager().persist(cualEsTuAnimal);
        getEntityManager().persist(bandaPodemosAprender);

        commit();
    }
}

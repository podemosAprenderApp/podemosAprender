import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import entities.usuarios.*;
import entities.usuarios.reaccionables.*;
import entities.usuarios.reaccionables.rasgos.*;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

class DomainTest extends TestBasicObjects {

    @Test
    void test_rasgos() {
        Assertions.assertEquals("Desarrollo en Java", jorge.getRasgos().get(0).getDescripcion());
    }

    @Test
    void test_reaccionar() {
        jorge.getRasgos().get(0).serReaccionado(reaccionDeJorge);
        Assertions.assertEquals("Me Divierte", jorge.getRasgos().get(0).getReacciones().get(0).getTipo().getNombre());
    }

    @Test
    void test_rasgo_reaccionar_varias_veces() {
        for (int i = 0; i < 5; i++) {
            jorge.getRasgos().get(0).serReaccionado(reaccionDeJorge);
        }
        Assertions.assertEquals(jorge.getRasgos().get(0).getReacciones().size(), 1);
    }

    @Test
    void test_rasgo_reaccionar_y_cambiar_reaccion() {
        jorge.getRasgos().get(0).serReaccionado(reaccionDeJorge);
        jorge.getRasgos().get(0).serReaccionado(reaccionEnojada);
        Assertions.assertEquals("Me Enoja", jorge.getRasgos().get(0).getReacciones().get(0).getTipo().getNombre());
    }

    @Test
    void test_rasgo_reaccionar_y_sacar_reaccion() {
        jorge.getRasgos().get(0).serReaccionado(reaccionDeJorge);
        jorge.getRasgos().get(0).sacarReaccion(reaccionDeJorge);
        Assertions.assertEquals(jorge.getRasgos().get(0).getReacciones().size(), 0);
    }

    @Test
    void test_rasgo_validable_puntuar() {
        tobias.getRasgosValidables().get(0).getExpertise().serPuntuado(puntuacion);
        Assertions.assertEquals(true, tobias.getRasgosValidables().get(0).getExpertise().getPuntuaciones().get(0).isPositiva());
    }

    @Test
    void test_rasgo_validable_puntuar_y_sacar_puntuacion() {
        tobias.getRasgosValidables().get(0).getExpertise().serPuntuado(puntuacion);
        tobias.getRasgosValidables().get(0).getExpertise().serDespuntuado(puntuacion);
        Assertions.assertEquals(0, tobias.getRasgosValidables().get(0).getExpertise().getPuntuaciones().size());
    }

    @Test
    void test_rasgo_validable_puntuar_varias_veces() {
        for (int i = 0; i < 5; i++)
            tobias.getRasgosValidables().get(0).getExpertise().serPuntuado(puntuacion);
        Assertions.assertEquals(1, tobias.getRasgosValidables().get(0).getExpertise().getPuntuaciones().size());
    }

    @Test
    void test_comentar_puntuacion() {
        tobias.getRasgosValidables().get(0).getExpertise().serPuntuado(puntuacion);
        tobias.getRasgosValidables().get(0).getExpertise().getPuntuaciones().get(0).setComentario(new Comentario(LocalDateTime.now(), "Sos un groso"));
        tobias.getRasgosValidables().get(0).getExpertise().getPuntuaciones().get(0).setRespuesta(new Comentario(LocalDateTime.now(), "Gracias capo"));
        Assertions.assertEquals("Sos un groso", tobias.getRasgosValidables().get(0).getExpertise().getPuntuaciones().get(0).getComentario().getTexto());
        Assertions.assertEquals("Gracias capo", tobias.getRasgosValidables().get(0).getExpertise().getPuntuaciones().get(0).getRespuesta().getTexto());
    }

}
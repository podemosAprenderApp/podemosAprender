package entities.usuarios.reaccionables.rasgos;

import entities.usuarios.reaccionables.Reaccion;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Habilidad extends RasgoValidable {

    public Habilidad(Topico topico, Expertise expertise, LocalDateTime fechaModificacion, List<Reaccion> reacciones) {
        super(topico, expertise, fechaModificacion, reacciones);
    }

    public Habilidad(){}
}

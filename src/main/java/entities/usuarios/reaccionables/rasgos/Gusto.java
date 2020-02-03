package entities.usuarios.reaccionables.rasgos;

import entities.usuarios.reaccionables.Reaccion;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Gusto extends Rasgo {
    public Gusto(Topico topico, LocalDateTime fechaModificacion, List<Reaccion> reacciones) {
        super(topico, fechaModificacion, reacciones);
    }

    public Gusto(){}
}

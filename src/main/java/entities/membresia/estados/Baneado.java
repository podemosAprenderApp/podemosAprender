package entities.membresia.estados;

import javax.persistence.Entity;
import java.time.LocalDateTime;
@Entity
public class Baneado extends EstadoMembresia {
    public Baneado(LocalDateTime fechaModificacion) {
        super(fechaModificacion);
    }

    public Baneado(){}
}

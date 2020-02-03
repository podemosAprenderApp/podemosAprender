package entities.membresia.estados;

import javax.persistence.Entity;
import java.time.LocalDateTime;
@Entity
public class Rechazado extends EstadoMembresia {
    public Rechazado(LocalDateTime fechaModificacion) {
        super(fechaModificacion);
    }

    public Rechazado(){}
}

package entities.membresia.estados;

import javax.persistence.Entity;
import java.time.LocalDateTime;
@Entity
public class Retirado extends EstadoMembresia {
    public Retirado(LocalDateTime fechaModificacion) {
        super(fechaModificacion);
    }

    public Retirado(){}
}

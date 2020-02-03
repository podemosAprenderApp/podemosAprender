package entities.membresia.estados;

import javax.persistence.Entity;
import java.time.LocalDateTime;
@Entity
public class Pendiente extends EstadoMembresia{
    public Pendiente(LocalDateTime fechaModificacion) {
        super(fechaModificacion);
    }

    public Pendiente(){}
}

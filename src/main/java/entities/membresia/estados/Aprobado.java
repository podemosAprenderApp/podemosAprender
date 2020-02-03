package entities.membresia.estados;

import javax.persistence.Entity;
import java.time.LocalDateTime;
@Entity
public class Aprobado extends EstadoMembresia{
    public Aprobado(LocalDateTime fechaModificacion) {
        super(fechaModificacion);
    }

    public Aprobado(){}
}

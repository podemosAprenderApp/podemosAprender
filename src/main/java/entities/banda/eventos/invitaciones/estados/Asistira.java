package entities.banda.eventos.invitaciones.estados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Asistira")
public class Asistira extends EstadoInvitacion {

    public Asistira(LocalDateTime fecha) {
        super(fecha);
    }

    public Asistira(){}
}

package entities.banda.eventos.invitaciones.estados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Pendiente")
public class PendienteInvitacion extends EstadoInvitacion {

    public PendienteInvitacion(LocalDateTime fecha) {
        super(fecha);
    }

    public PendienteInvitacion(){}
}

package entities.banda.eventos.invitaciones.estados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("NoAsistira")
public class NoAsistira extends EstadoInvitacion {

    public NoAsistira(LocalDateTime fecha) {
        super(fecha);
    }
    public NoAsistira() {

    }
}

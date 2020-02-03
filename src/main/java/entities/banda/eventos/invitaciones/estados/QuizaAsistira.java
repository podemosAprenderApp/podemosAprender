package entities.banda.eventos.invitaciones.estados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("QuizaAsistira")
public class QuizaAsistira extends EstadoInvitacion {
    public QuizaAsistira(LocalDateTime fecha) {
        super(fecha);
    }

    public QuizaAsistira(){}
}

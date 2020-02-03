package entities.banda.eventos.invitaciones.estados;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;
import entities.banda.eventos.invitaciones.Invitacion;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "estados_invitaciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_estado")
public class EstadoInvitacion extends EntidadPersistente {

    @Column(name = "fecha_modificacion") @Expose
    private LocalDateTime fechaModificacion;

    public EstadoInvitacion(LocalDateTime fecha) {
        this.fechaModificacion = fecha;
    }

    public EstadoInvitacion() {
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public void cambiarA(Invitacion invitacion, EstadoInvitacion estado) {
        invitacion.setEstado(estado);
    }
}

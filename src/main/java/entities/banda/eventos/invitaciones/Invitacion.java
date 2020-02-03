package entities.banda.eventos.invitaciones;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;
import entities.banda.eventos.invitaciones.estados.EstadoInvitacion;
import entities.usuarios.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "invitaciones")
public class Invitacion extends EntidadPersistente {
    @Column(name = "fecha") @Expose
    private LocalDateTime fecha;
    @ManyToOne @Expose
    @JoinColumn(name="invitado_id", nullable=false)
    private Usuario invitado;
    @ManyToOne @Expose
    @JoinColumn(name = "estado_id")
    private EstadoInvitacion estado;
    @ManyToOne @Expose
    @JoinColumn(name = "invitante_id")
    private Usuario invitante;

    public Invitacion(){}

    public Invitacion(Usuario invitado, Usuario invitante, EstadoInvitacion estado, LocalDateTime fecha){
        this.invitado = invitado;
        this.invitante = invitante;
        this.estado = estado;
        this.fecha = fecha;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getInvitado() {
        return invitado;
    }

    public void setInvitado(Usuario invitado) {
        this.invitado = invitado;
    }

    public Usuario getInvitante() {
        return invitante;
    }

    public void setInvitante(Usuario invitante) {
        this.invitante = invitante;
    }

    public EstadoInvitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoInvitacion estado) {
        this.estado = estado;
    }
}

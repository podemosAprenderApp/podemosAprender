package entities.banda.eventos;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;
import entities.banda.eventos.invitaciones.Invitacion;
import entities.banda.eventos.visibilidades.Visibilidad;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "eventos")
public class Evento extends EntidadPersistente {
    @Column(name = "fecha") @Expose
    private LocalDateTime fecha;
    @Column(name = "titulo") @Expose
    private String titulo;
    @Column(name = "contenido") @Expose
    private String contenido;
    @OneToMany @Expose
    private List<Invitacion> invitaciones;
    @Column(name = "locacion") @Expose
    private String locacion;
    @OneToOne(cascade = CascadeType.ALL)
    private Visibilidad visible;

    public Evento(LocalDateTime fecha, String titulo, String contenido, List<Invitacion> invitaciones, String locacion, Visibilidad visible) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.contenido = contenido;
        this.invitaciones = invitaciones;
        this.locacion = locacion;
        this.visible = visible;
    }

    public Evento(){}

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public List<Invitacion> getInvitaciones() {
        return invitaciones;
    }

    public void setInvitaciones(List<Invitacion> invitaciones) {
        this.invitaciones = invitaciones;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public Visibilidad getVisible() {
        return visible;
    }

    public void setVisible(Visibilidad visible) {
        this.visible = visible;
    }
}

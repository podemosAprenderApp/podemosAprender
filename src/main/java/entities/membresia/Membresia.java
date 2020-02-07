package entities.membresia;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;
import entities.membresia.estados.EstadoMembresia;
import entities.permisos.Rol;
import entities.usuarios.Usuario;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "membresias")
public class Membresia extends EntidadPersistente {
    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    @Expose
    private Usuario usuario;
    @OneToOne @Expose
    private EstadoMembresia estado;
    @OneToMany @Expose
    private List<Respuesta> respuestas;
    @OneToMany @Expose
    private List<EstadoMembresia> historialEstados;
    @ManyToOne @Expose
    private Rol rol;
    @ManyToMany @Expose
    @JoinTable(name = "etiquetas_membresias")
    private List<Etiqueta> etiquetas;

    public Membresia(Usuario usuario, EstadoMembresia estado, List<Respuesta> respuestas, List<EstadoMembresia> historialEstados, Rol rol, List<Etiqueta> etiquetas) {
        this.usuario = usuario;
        this.estado = estado;
        this.respuestas = respuestas;
        this.historialEstados = historialEstados;
        this.rol = rol;
        this.etiquetas = etiquetas;
    }

    public Membresia(){}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public List<EstadoMembresia> getHistorialEstados() {
        return historialEstados;
    }

    public void setHistorialEstados(List<EstadoMembresia> historialEstados) {
        this.historialEstados = historialEstados;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public EstadoMembresia getEstado() {
        return estado;
    }

    public void setEstado(EstadoMembresia estado) {
        this.estado = estado;
    }

    public void agregarEstadoAHistorial(EstadoMembresia estado) {
        historialEstados.add(estado);
    }
}

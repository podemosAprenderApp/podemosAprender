package entities.membresia.estados;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;
import entities.membresia.Membresia;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "estados_membresia")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class EstadoMembresia extends EntidadPersistente {
    @Column @Expose
    private LocalDateTime fechaModificacion;

    public EstadoMembresia(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public EstadoMembresia(){}

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    private void cambiarA(Membresia membresia, EstadoMembresia estado){
        membresia.agregarEstadoAHistorial(membresia.getEstado());
        membresia.setEstado(estado);
    }
}

package entities.permisos;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permisos")
public class Permiso extends EntidadPersistente {
    @Column  @Expose
    private String descripcion;

    public Permiso(String descripcion) {
        this.descripcion = descripcion;
    }

    public Permiso(){}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

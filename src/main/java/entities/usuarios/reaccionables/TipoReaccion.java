package entities.usuarios.reaccionables;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_reacciones")
public class TipoReaccion extends EntidadPersistente {
    @Column  @Expose
    private String nombre;

    public TipoReaccion(String nombre) {
        this.nombre = nombre;
    }

    public TipoReaccion(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

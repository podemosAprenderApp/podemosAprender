package entities.usuarios.reaccionables.rasgos;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_expertise")
public class TipoExpertise extends EntidadPersistente {
    @Column @Expose
    private String descripcion;

    public TipoExpertise(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoExpertise(){}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

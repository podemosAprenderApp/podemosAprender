package entities.permisos;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Rol extends EntidadPersistente {
    @ManyToMany  @Expose
    private List<Permiso> permisos;

    public Rol(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public Rol(){}

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }
}

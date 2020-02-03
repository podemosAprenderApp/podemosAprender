package entities.usuarios.reaccionables;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;
@MappedSuperclass
public abstract class Reaccionable extends EntidadPersistente {
    @OneToMany @Expose
    private List<Reaccion> reacciones;

    public Reaccionable(List<Reaccion> reacciones) {
        this.reacciones = reacciones;
    }

    public Reaccionable(){}

    public List<Reaccion> getReacciones() {
        return reacciones;
    }

    public void setReacciones(List<Reaccion> reacciones) {
        this.reacciones = reacciones;
    }

    public void serReaccionado(Reaccion nuevaReaccion){
        reacciones.removeIf(reaccion -> reaccion.getAutor().equals(nuevaReaccion.getAutor()));
        reacciones.add(nuevaReaccion);
    }

    public void sacarReaccion(Reaccion reaccion){
        reacciones.remove(reaccion);
    }
}

package entities.usuarios.reaccionables.rasgos;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "expertise")
public class Expertise extends EntidadPersistente {
    @ManyToOne @Expose
    private TipoExpertise tipoExpertise;
    @OneToMany @Expose
    private List<Puntuacion> puntuaciones;

    public Expertise(TipoExpertise tipoExpertise, List<Puntuacion> puntuaciones) {
        this.tipoExpertise = tipoExpertise;
        this.puntuaciones = puntuaciones;
    }

    public Expertise(){}

    public List<Puntuacion> getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(List<Puntuacion> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }

    public void serPuntuado(Puntuacion nuevaPuntuacion) {
        puntuaciones.removeIf(puntuacion ->
                puntuacion.getUsuarioPuntuador().equals(nuevaPuntuacion.getUsuarioPuntuador()));
        puntuaciones.add(nuevaPuntuacion);
    }

    public void serDespuntuado(Puntuacion puntuacion) {
        puntuaciones.remove(puntuacion);
    }

    public String getDescripcion() {
        return tipoExpertise.getDescripcion();
    }

    public TipoExpertise getTipoExpertise() {
        return tipoExpertise;
    }

    public void setTipoExpertise(TipoExpertise tipoExpertise) {
        this.tipoExpertise = tipoExpertise;
    }
}

package entities.usuarios.reaccionables.rasgos;

import com.google.gson.annotations.Expose;
import entities.usuarios.reaccionables.Reaccion;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RasgoValidable extends Rasgo{
    @OneToOne @Expose
    private Expertise expertise;

    public RasgoValidable(Topico topico, Expertise expertise, LocalDateTime fechaModificacion, List<Reaccion> reacciones) {
        super(topico, fechaModificacion, reacciones);
        this.expertise = expertise;
    }

    public RasgoValidable(){}

    public void serPuntuado(Puntuacion puntuacion){
        expertise.serPuntuado(puntuacion);
    }

    public void serDespuntuado(Puntuacion puntuacion){
        expertise.serDespuntuado(puntuacion);
    }

    public Expertise getExpertise(){
        return expertise;
    }

    public void setExpertise(Expertise expertise){
        this.expertise = expertise;
    }
}

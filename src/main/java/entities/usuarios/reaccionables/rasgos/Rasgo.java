package entities.usuarios.reaccionables.rasgos;

import com.google.gson.annotations.Expose;
import entities.usuarios.reaccionables.Reaccion;
import entities.usuarios.reaccionables.Reaccionable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "rasgos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Rasgo extends Reaccionable {
    @ManyToOne @Expose
    private Topico topico;
    @Column(name = "fecha_modificacion") @Expose
    protected LocalDateTime fechaModificacion;

    public Rasgo(Topico topico, LocalDateTime fechaModificacion, List<Reaccion> reacciones) {
        super(reacciones);
        this.topico = topico;
        this.fechaModificacion = fechaModificacion;
    }

    public Rasgo(){}

    public Topico getTopico(){
        return topico;
    }

    public void setTopico(Topico topico){
        this.topico = topico;
    }

    public String getDescripcion(){
        return topico.getDescripcion();
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}

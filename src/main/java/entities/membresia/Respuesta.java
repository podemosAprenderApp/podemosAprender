package entities.membresia;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;
import entities.banda.Pregunta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "respuestas")
public class Respuesta extends EntidadPersistente {
    @Column(name = "texto") @Expose
    private String texto;
    @ManyToOne @Expose
    private Pregunta pregunta;
    @Column(name = "fecha") @Expose
    private LocalDateTime fecha;

    public Respuesta(String texto, Pregunta pregunta, LocalDateTime fecha) {
        this.texto = texto;
        this.pregunta = pregunta;
        this.fecha = fecha;
    }

    public Respuesta(){}

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

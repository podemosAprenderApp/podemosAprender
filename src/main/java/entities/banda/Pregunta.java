package entities.banda;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "preguntas")
public class Pregunta extends EntidadPersistente {
    @Column(name = "texto") @Expose
    private String texto;
    @Column(name = "orden") @Expose
    private Integer orden;
    @Column(name = "fecha_modificacion") @Expose
    private LocalDateTime fechaModificacion;

    public Pregunta(String texto, Integer orden, LocalDateTime fechaModificacion) {
        this.texto = texto;
        this.orden = orden;
        this.fechaModificacion = fechaModificacion;
    }

    public Pregunta(){}

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

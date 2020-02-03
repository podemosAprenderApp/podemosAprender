package entities.usuarios.reaccionables.rasgos;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
public class Comentario extends EntidadPersistente {
    @Column(name = "fecha") @Expose
    private LocalDateTime fecha;
    @Column(name = "texto") @Expose
    private String texto;

    public Comentario(LocalDateTime fecha, String texto) {
        this.fecha = fecha;
        this.texto = texto;
    }

    public Comentario(){}

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

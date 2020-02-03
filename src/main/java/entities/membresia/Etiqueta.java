package entities.membresia;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "etiquetas")
public class Etiqueta extends EntidadPersistente {
    @Column(name = "texto") @Expose
    private String texto;

    public Etiqueta(String texto) {
        this.texto = texto;
    }

    public Etiqueta(){}

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

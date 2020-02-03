package entities.banda;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reglas")
public class Regla extends EntidadPersistente {
    @Column(name = "texto") @Expose
    private String texto;

    public Regla(String texto) {
        this.texto = texto;
    }

    public Regla(){}

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

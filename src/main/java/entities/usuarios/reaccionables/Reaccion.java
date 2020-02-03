package entities.usuarios.reaccionables;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;
import entities.usuarios.Usuario;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reacciones")
public class Reaccion extends EntidadPersistente {
    @ManyToOne @Expose
    private TipoReaccion tipo;
    @ManyToOne @Expose
    private Usuario autor;

    public Reaccion(TipoReaccion tipo, Usuario usuario){
        this.tipo = tipo;
        this.autor = usuario;
    }

    public Reaccion(){}

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public TipoReaccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoReaccion tipo) {
        this.tipo = tipo;
    }
}

package entities.usuarios.reaccionables;

import com.google.gson.annotations.Expose;
import entities.usuarios.Usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "posts")
public class Post extends Reaccionable {
    @Column @Expose
    private String contenido;
    @ManyToOne @Expose
    private Usuario autor;

    public Post(String contenido, List<Reaccion> reacciones, Usuario autor) {
        super(reacciones);
        this.contenido = contenido;
        this.autor = autor;
    }

    public Post(){}

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}

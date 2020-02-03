package entities.usuarios.reaccionables;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "posts")
public class Post extends Reaccionable {
    @Column @Expose
    private String contenido;

    public Post(String contenido, List<Reaccion> reacciones) {
        super(reacciones);
        this.contenido = contenido;
    }

    public Post(){}

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

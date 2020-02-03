package entities.usuarios.reaccionables.rasgos;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;
import entities.usuarios.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "puntuaciones")
public class Puntuacion extends EntidadPersistente {
    @Column(name = "es_positiva") @Expose
    private boolean positiva;
    @OneToOne @Expose
    private Comentario comentario;
    @OneToOne @Expose
    private Comentario respuesta;
    @ManyToOne @Expose
    private Usuario usuarioPuntuador;

    public Puntuacion(boolean esPositiva, Comentario comentario, Comentario respuesta, Usuario usuarioPuntuador) {
        this.positiva = esPositiva;
        this.comentario = comentario;
        this.respuesta = respuesta;
        this.usuarioPuntuador = usuarioPuntuador;
    }

    public Puntuacion(){}

    public Usuario getUsuarioPuntuador() {
        return usuarioPuntuador;
    }

    public void setUsuarioPuntuador(Usuario usuarioPuntuador) {
        this.usuarioPuntuador = usuarioPuntuador;
    }

    public Comentario getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Comentario respuesta) {
        this.respuesta = respuesta;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public boolean isPositiva() {
        return positiva;
    }

    public void setPositiva(boolean esPositiva) {
        this.positiva = esPositiva;
    }
}

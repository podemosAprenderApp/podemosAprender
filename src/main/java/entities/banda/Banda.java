package entities.banda;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;
import entities.banda.eventos.Evento;
import entities.membresia.Membresia;
import entities.usuarios.reaccionables.Post;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bandas")
public class Banda extends EntidadPersistente {
    @Column(name = "nombre") @Expose
    private String nombre;
    @Column(name = "presentacion") @Expose
    private String presentacion;
    @OneToMany @Expose
    private List<Regla> reglas;
    @OneToMany @Expose
    private List<Pregunta> preguntas;
    @OneToMany @Expose
    private List<Membresia> membresias;
    @OneToMany @Expose
    private List<Evento> eventos;
    @OneToMany @Expose
    private List<Post> posts;

    public Banda(String nombre, String presentacion, List<Regla> reglas, List<Pregunta> preguntas, List<Membresia> membresias, List<Evento> eventos, List<Post> posts) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.reglas = reglas;
        this.preguntas = preguntas;
        this.membresias = membresias;
        this.eventos = eventos;
        this.posts = posts;
    }

    public Banda(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public List<Regla> getReglas() {
        return reglas;
    }

    public void setReglas(List<Regla> reglas) {
        this.reglas = reglas;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public List<Membresia> getMembresias() {
        return membresias;
    }

    public void setMembresias(List<Membresia> membresias) {
        this.membresias = membresias;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

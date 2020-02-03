package entities.usuarios;

import com.google.gson.annotations.Expose;
import db.EntidadPersistente;
import entities.usuarios.reaccionables.rasgos.Rasgo;
import entities.usuarios.reaccionables.rasgos.RasgoValidable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "usuarios")
public class Usuario extends EntidadPersistente {
    @Column @Expose
    private LocalDateTime fechaRegistro;
    @OneToMany @Expose
    private List<Rasgo> rasgos;
    @Column @Expose
    private String nombre;
    @Column @Expose
    private String username;
    @Column
    private String hash;

    public Usuario(LocalDateTime fechaRegistro, List<Rasgo> rasgos, String nombre, String username, String hash) {
        this.fechaRegistro = fechaRegistro;
        this.rasgos = rasgos;
        this.nombre = nombre;
        this.username = username;
        this.hash = hash;
    }

    public Usuario(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Rasgo> getRasgos() {
        return rasgos;
    }

    public void setRasgos(List<Rasgo> rasgos) {
        this.rasgos = rasgos;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<RasgoValidable> getRasgosValidables(){
        return (List<RasgoValidable>)
                getRasgos().stream()
                .filter(rasgo -> rasgo instanceof RasgoValidable)
                .map(RasgoValidable.class::cast)
                .collect(Collectors.toList());
    }

    public void agregar(Rasgo rasgo){
        rasgos.add(rasgo);
    }

    public void remover(Rasgo rasgo){
        rasgos.remove(rasgo);
    }
}

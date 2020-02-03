package entities.banda.eventos.visibilidades;

import db.EntidadPersistente;
import entities.usuarios.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "visibilidades")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Visibilidad extends EntidadPersistente {
    abstract boolean sePuedeMostrarA(Usuario usuario);
}

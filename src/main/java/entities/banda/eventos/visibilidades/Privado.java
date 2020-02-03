package entities.banda.eventos.visibilidades;

import db.EntidadPersistente;
import entities.usuarios.Usuario;

import javax.persistence.Entity;

@Entity
public class Privado extends Visibilidad {
    @Override
    public boolean sePuedeMostrarA(Usuario usuario) {
        return false;
    }

    public Privado(){}
}

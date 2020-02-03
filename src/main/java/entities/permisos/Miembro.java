package entities.permisos;

import javax.persistence.Entity;
import java.util.List;
@Entity
public class Miembro extends Rol {
    public Miembro(List<Permiso> permisos) {
        super(permisos);
    }

    public Miembro(){}
}

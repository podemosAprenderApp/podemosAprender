package entities.permisos;

import javax.persistence.Entity;
import java.util.List;
@Entity
public class Admin extends Rol{
    public Admin(List<Permiso> permisos) {
        super(permisos);
    }

    public Admin(){}
}

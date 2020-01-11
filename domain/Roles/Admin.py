from domain.Roles.Miembro import Miembro
from domain.Roles.Permiso import Permiso


class Admin (Miembro):
    def __init__(self):
        super().__init__()
        super().permisos.extend([Permiso("Agregar regla"),
                                 Permiso("Remover regla"),
                                 Permiso("Agregar pregunta"),
                                 Permiso("Remover pregunta"),
                                 Permiso("Agregar post"),
                                 Permiso("Remover post"),
                                 Permiso("Agregar Evento"),
                                 Permiso("Remover evento"),
                                 Permiso("Aceptar miembro"),
                                 Permiso("Rechazar miembro"),
                                 Permiso("Bloquear miembro"),
                                 Permiso("Desbloquear miembro"),
                                 Permiso("Expulsar miembro")])

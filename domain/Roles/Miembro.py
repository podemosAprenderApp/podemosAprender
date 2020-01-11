from domain.Roles.Permiso import Permiso
from domain.Roles.Rol import Rol


class Miembro (Rol):
    def __init__(self) -> None:
        super().__init__([Permiso("Unirse a una banda"),
                          Permiso("Salir de una banda"),
                          Permiso("Crear una banda"),
                          Permiso("Reaccionar")])

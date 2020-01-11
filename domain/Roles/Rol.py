from typing import List

from domain.Roles.Permiso import Permiso


class Rol:
    def __init__(self, permisos) -> None:
        self.permisos: List[Permiso] = permisos


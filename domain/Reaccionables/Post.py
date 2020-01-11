from datetime import datetime
from typing import List

from domain.Bandas.Usuario import Usuario
from domain.Reaccionables.Reaccion import Reaccion
from domain.Reaccionables.Reaccionable import Reaccionable


class Post (Reaccionable):
    def __init__(self, reacciones: List[Reaccion], fecha: datetime, titulo: str, contenido: str, autor: Usuario) -> None:
        super().__init__(reacciones)
        self.fecha: datetime = fecha
        self.titulo: str = titulo
        self.contenido: str = contenido
        self.autor: Usuario = autor


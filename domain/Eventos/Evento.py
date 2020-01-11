from datetime import datetime
from typing import List

from domain.Eventos.Invitacion import Invitacion


class Evento:
    def __init__(self, fecha: datetime, titulo: str, contenido: str,
                 invitaciones: List[Invitacion], lugar: str, publico: bool) -> None:
        self.fecha: datetime = fecha
        self.titulo: str = titulo
        self.contenido: str = contenido
        self.invitaciones: List[Invitacion] = invitaciones
        self.lugar: str = lugar
        self.publico: bool = publico

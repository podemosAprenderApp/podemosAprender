from datetime import datetime
from typing import List

from domain.Reaccionables.Reaccion import Reaccion
from domain.Reaccionables.Reaccionable import Reaccionable


class Rasgo (Reaccionable):
    def __init__(self, reacciones: List[Reaccion], texto: str, fecha_modificacion: datetime) -> None:
        super().__init__(reacciones)
        self.texto: str = texto
        self.fecha_modificacion: datetime = fecha_modificacion

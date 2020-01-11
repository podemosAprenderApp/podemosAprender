from datetime import datetime
from typing import List

from domain.Reaccionables.Rasgo import Rasgo
from domain.Reaccionables.Reaccion import Reaccion


class Interes(Rasgo):
    def __init__(self, reacciones: List[Reaccion], texto: str, fecha_modificacion: datetime) -> None:
        super().__init__(reacciones, texto, fecha_modificacion)

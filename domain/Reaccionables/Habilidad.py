from datetime import datetime
from typing import List

from domain.Reaccionables.Expertise import Expertise
from domain.Reaccionables.RasgoValidable import RasgoValidable
from domain.Reaccionables.Reaccion import Reaccion


class Habilidad(RasgoValidable):
    def __init__(self, reacciones: List[Reaccion], texto: str, fecha_modificacion: datetime, expertise: Expertise) -> None:
        super().__init__(reacciones, texto, fecha_modificacion, expertise)

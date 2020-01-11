from datetime import datetime
from typing import List

from domain.Reaccionables.Rasgo import Rasgo
from domain.Reaccionables.RasgoValidable import RasgoValidable


class Usuario:
    def __init__(self, fecha_registro: datetime, rasgos: List[Rasgo], nombre: str, username: str, hashed: str) -> None:
        self.fecha_registro: datetime = fecha_registro
        self.rasgos: List[Rasgo] = rasgos
        self.nombre: str = nombre
        self.username: str = username
        self.hashed: str = hashed

    def rasgos_validables(self):
        return [rasgo for rasgo in self.rasgos if isinstance(rasgo, RasgoValidable)]



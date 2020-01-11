from datetime import datetime

from domain.EstadosMembresia.EstadoMembresia import EstadoMembresia


class Bloqueado(EstadoMembresia):
    def __init__(self, fecha: datetime) -> None:
        super().__init__(fecha)

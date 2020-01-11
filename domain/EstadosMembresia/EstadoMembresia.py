from datetime import datetime

from domain.Bandas.Membresia import Membresia


class EstadoMembresia:
    def __init__(self, fecha: datetime) -> None:
        self.fecha: datetime = fecha

    def cambiar(self, membresia: Membresia, nuevo_estado_membresia: 'EstadoMembresia') -> None:
        membresia.historial_estados.append(membresia.estado_membresia)
        membresia.estado_membresia = nuevo_estado_membresia


from datetime import datetime

from domain.Bandas.Membresia import Membresia
from domain.Bandas.Respuesta import Respuesta


class Pregunta:
    def __init__(self, texto: str, orden: int, fecha: datetime) -> None:
        self.texto: str = texto
        self.orden: int = orden
        self.fecha: datetime = fecha

    def ser_respondida(self, membresia: Membresia, respuesta: Respuesta) -> None:
        membresia.respuestas.append(respuesta)



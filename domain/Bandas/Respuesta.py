from datetime import datetime

from domain.Bandas.Membresia import Membresia
from domain.Bandas.Pregunta import Pregunta


class Respuesta:
    def __init__(self, membresia: Membresia, texto: str, pregunta: Pregunta, fecha: datetime) -> None:
        self.membresia: Membresia = membresia
        self.texto: str = texto
        self.pregunta: Pregunta = pregunta
        self.fecha: datetime = fecha

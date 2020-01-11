from datetime import datetime


class Comentario:
    def __init__(self, fecha: datetime, texto: str) -> None:
        self.fecha: datetime = fecha
        self.texto: str = texto

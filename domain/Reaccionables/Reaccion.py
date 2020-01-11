from domain.Bandas import Usuario
from domain.Reaccionables import TipoReaccion


class Reaccion:
    def __init__(self, tipo: TipoReaccion, autor: Usuario) -> None:
        self.tipo: TipoReaccion = tipo
        self.autor: Usuario = autor

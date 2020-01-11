from domain.Bandas import Usuario
from domain.Reaccionables.Comentario import Comentario


class Puntuacion:
    def __init__(self, es_positiva: bool, comentario: Comentario, respuesta: Comentario, autor: Usuario) -> None:
        self.es_positiva: bool = es_positiva
        self.comentario: Comentario = comentario
        self.respuesta: Comentario = respuesta
        self.autor: Usuario = autor

    def responder(self, comentario: Comentario) -> None:
        self.respuesta = comentario

    def comentar(self, comentario: Comentario) -> None:
        self.comentario = comentario

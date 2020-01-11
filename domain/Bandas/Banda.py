from typing import List

from domain.Bandas.Membresia import Membresia
from domain.Bandas.Pregunta import Pregunta
from domain.Bandas.Regla import Regla
from domain.Eventos.Evento import Evento
from domain.Reaccionables.Post import Post


class Banda:
    def __init__(self, nombre: str, presentacion: str, reglas: List[Regla], preguntas: List[Pregunta],
                 membresias: List[Membresia], eventos: List[Evento], posts: List[Post]) -> None:
        self.nombre: str = nombre
        self.presentacion: str = presentacion
        self.reglas: List[Regla] = reglas
        self.preguntas: List[Pregunta] = preguntas
        self.membresias: List[Membresia] = membresias
        self.eventos: List[Evento] = eventos
        self.posts: List[Post] = posts

    def agregar_membresia(self, membresia: Membresia) -> None:
        self.membresias.append(membresia)

    def agregar_regla(self, regla: Regla) -> None:
        self.reglas.append(regla)

    def agregar_pregunta(self, pregunta: Pregunta) -> None:
        self.preguntas.append(pregunta)

    def agregar_post(self, membresia: Membresia) -> None:
        self.membresias.append(membresia)

    def agregar_evento(self, evento: Evento) -> None:
        self.eventos.append(evento)

    def remover_membresia(self, membresia: Membresia) -> None:
        self.membresias.remove(membresia)

    def remover_regla(self, regla: Regla) -> None:
        self.reglas.remove(regla)

    def remover_pregunta(self, pregunta: Pregunta) -> None:
        self.preguntas.remove(pregunta)

    def remover_post(self, post: Post) -> None:
        self.posts.remove(post)

    def remover_evento(self, evento: Evento) -> None:
        self.eventos.remove(evento)

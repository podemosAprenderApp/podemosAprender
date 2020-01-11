from typing import List

from domain.Reaccionables.Puntuacion import Puntuacion


class Expertise:
    def __init__(self, texto: str, puntuaciones: List[Puntuacion]) -> None:
        self.puntuaciones: List[Puntuacion] = puntuaciones
        self.texto: str = texto

    def ser_puntuado(self, puntuacion: Puntuacion) -> None:
        ya_reaccionado = False
        for indexOfElem in range(len(self.puntuaciones)):
            if self.puntuaciones[indexOfElem].autor == puntuacion.autor:
                self.puntuaciones[indexOfElem] = puntuacion
                ya_reaccionado = True
        if not ya_reaccionado:
            self.puntuaciones.append(puntuacion)

    def ser_despuntuado(self, puntuacion: Puntuacion) -> None:
        if any(puntuacion.autor == elem.autor for elem in self.puntuaciones):
            self.puntuaciones.remove(puntuacion)

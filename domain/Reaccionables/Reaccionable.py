from typing import List

from domain.Reaccionables.Reaccion import Reaccion


class Reaccionable:
    def __init__(self, reacciones: List[Reaccion]) -> None:
        self.reacciones: List[Reaccion] = reacciones

    def ser_reaccionado(self, reaccion) -> None:
        ya_reaccionado = False
        for indexOfElem in range(len(self.reacciones)):
            if self.reacciones[indexOfElem].autor == reaccion.autor:
                self.reacciones[indexOfElem] = reaccion
                ya_reaccionado = True
        if not ya_reaccionado:
            self.reacciones.append(reaccion)

    def sacar_reaccion(self, reaccion) -> None:
        if any(reaccion.autor == elem.autor for elem in self.reacciones):
            self.reacciones.remove(reaccion)


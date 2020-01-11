class Reaccionable:
    def __init__(self, reacciones):
        self.reacciones = reacciones

    def serReaccionado(self, reaccion):
        ya_reaccionado = False
        for indexOfElem in range(len(self.reacciones)):
            if self.reacciones[indexOfElem].autor == reaccion.autor:
                self.reacciones[indexOfElem] = reaccion
                ya_reaccionado = True
        if not ya_reaccionado:
            self.reacciones.append(reaccion)

    def sacarReaccion(self, reaccion):
        if any(reaccion.autor == elem.autor for elem in self.reacciones):
            self.reacciones.remove(reaccion)


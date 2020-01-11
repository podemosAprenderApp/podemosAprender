class Expertise:
    def __init__(self, texto, puntuaciones):
        self.puntuaciones = puntuaciones
        self.texto = texto

    def serPuntuado(self, puntuacion):
        ya_reaccionado = False
        for indexOfElem in range(len(self.puntuaciones)):
            if self.puntuaciones[indexOfElem].autor == puntuacion.autor:
                self.puntuaciones[indexOfElem] = puntuacion
                ya_reaccionado = True
        if not ya_reaccionado:
            self.puntuaciones.append(puntuacion)

    def serDespuntuado(self, puntuacion):
        if any(puntuacion.autor == elem.autor for elem in self.puntuaciones):
            self.puntuaciones.remove(puntuacion)

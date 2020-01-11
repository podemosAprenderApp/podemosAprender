from domain.Reaccionables.Rasgo import Rasgo


class Gusto(Rasgo):
    def __init__(self, reacciones, texto, fecha_modificacion):
        super().__init__(reacciones, texto, fecha_modificacion)

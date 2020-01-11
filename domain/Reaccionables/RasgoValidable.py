from domain.Reaccionables.Rasgo import Rasgo


class RasgoValidable(Rasgo):
    def __init__(self, reacciones, texto, fecha_modificacion, expertise):
        super().__init__(reacciones, texto, fecha_modificacion)
        self.expertise = expertise


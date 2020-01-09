from domain.Reaccionables.RasgoValidable import RasgoValidable


class Habilidad(RasgoValidable):
    def __init__(self, reacciones, texto, fecha_modificacion, expertise):
        super().__init__(reacciones, texto, fecha_modificacion, expertise)

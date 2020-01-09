from domain.Reaccionables.Reaccionable import Reaccionable


class Rasgo (Reaccionable):
    def __init__(self, reacciones, texto, fecha_modificacion):
        super().__init__(reacciones)
        self.texto = texto
        self.fecha_modificacion = fecha_modificacion

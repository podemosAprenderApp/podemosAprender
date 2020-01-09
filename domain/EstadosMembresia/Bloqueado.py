from domain.EstadosMembresia.EstadoMembresia import EstadoMembresia


class Bloqueado(EstadoMembresia):
    def __init__(self, fecha):
        super().__init__(fecha)

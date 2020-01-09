from domain.EstadosMembresia.EstadoMembresia import EstadoMembresia


class Pendiente(EstadoMembresia):
    def __init__(self, fecha):
        super().__init__(fecha)

from domain.Eventos import EstadoInvitacion


class Pendiente(EstadoInvitacion):
    def __init__(self, fecha):
        super().__init__(fecha)

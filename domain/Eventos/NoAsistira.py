from domain.Eventos import EstadoInvitacion


class Asistira(EstadoInvitacion):
    def __init__(self, fecha):
        super().__init__(fecha)

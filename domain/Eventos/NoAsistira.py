from datetime import datetime

from domain.Eventos import EstadoInvitacion


class Asistira(EstadoInvitacion):
    def __init__(self, fecha: datetime) -> None:
        super().__init__(fecha)

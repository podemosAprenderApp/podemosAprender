from datetime import datetime

from domain.Eventos.Invitacion import Invitacion


class EstadoInvitacion:
    def __init__(self, fecha: datetime) -> None:
        self.fecha: datetime = fecha

    def cambiarA(self, invitacion: Invitacion, estado: 'EstadoInvitacion') -> None:
        invitacion.estadoInvitacion = estado


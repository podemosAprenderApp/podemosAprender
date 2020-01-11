from datetime import datetime

from domain.Bandas.Usuario import Usuario
from domain.Eventos.EstadoInvitacion import EstadoInvitacion


class Invitacion:
    def __init__(self, fecha, invitado, estado_invitacion, invitante) -> None:
        self.fecha: datetime = fecha
        self.invitado: Usuario = invitado
        self.estado_invitacion: EstadoInvitacion = estado_invitacion
        self.invitante: Usuario = invitante


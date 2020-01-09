class EstadoInvitacion:
    def __init__(self, fecha):
        self.fecha = fecha

    def cambiarA(self, invitacion, estado):
        invitacion.estadoInvitacion = estado


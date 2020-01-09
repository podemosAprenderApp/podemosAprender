from domain.Eventos import EstadoInvitacion


class QuizaAsista(EstadoInvitacion):
    def __init__(self, fecha):
        super().__init__(fecha)

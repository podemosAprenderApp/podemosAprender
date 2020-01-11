class Puntuacion:
    def __init__(self, esPositiva, comentario, respuesta, autor):
        self.esPositiva = esPositiva
        self.comentario = comentario
        self.respuesta = respuesta
        self.autor = autor

    def responder(self, comentario):
        self.respuesta = comentario

    def comentar(self, comentario):
        self.comentario = comentario

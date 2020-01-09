class Banda:
    def __init__(self, nombre, presentacion, reglas, preguntas, membresias, eventos, posts):
        self.nombre = nombre
        self.presentacion = presentacion
        self.reglas = reglas
        self.preguntas = preguntas
        self.membresias = membresias
        self.eventos = eventos
        self.posts = posts

    def agregarMembresia(self, membresia):
        self.membresias.append(membresia)

    def agregarRegla(self, regla):
        self.reglas.append(regla)

    def agregarPregunta(self, pregunta):
        self.preguntas.append(pregunta)

    def agregarPost(self, membresia):
        self.membresias.append(membresia)

    def agregarEvento(self, evento):
        self.eventos.append(evento)

    def removerMembresia(self, membresia):
        self.membresias.remove(membresia)

    def removerRegla(self, regla):
        self.reglas.remove(regla)

    def removerPregunta(self, pregunta):
        self.preguntas.remove(pregunta)

    def removerPost(self, post):
        self.posts.remove(post)

    def removerEvento(self, evento):
        self.eventos.remove(evento)

class EstadoMembresia:
    def __init__(self, fecha):
        self.fecha = fecha

    def cambiar(self, membresia, estadoMembresia):
        membresia.estadoMembresia = estadoMembresia


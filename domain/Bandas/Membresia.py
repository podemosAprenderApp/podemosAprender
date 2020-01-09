class Membresia:
    def __init__(self, usuario, estadoMembresia, respuestas, historialEstados, rol, etiquetas):
        self.usuario = usuario
        self.estadoMembresia = estadoMembresia
        self.respuestas = respuestas
        self.historialEstados = historialEstados
        self.rol = rol
        self.etiquetas = etiquetas

    def agregarEtiqueta(self, etiqueta):
        self.etiquetas.append(etiqueta)

    def removerEtiqueta(self, etiqueta):
        self.etiquetas.remove(etiqueta)

    def cambiarRolA(self, rol):
        self.rol = rol

    def cambiarEstadoMembresiaA(self, estadoMembresia):
        self.historialEstados.append(self.estadoMembresia)
        self.estadoMembresia = estadoMembresia

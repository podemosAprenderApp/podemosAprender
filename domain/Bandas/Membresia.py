from typing import List

from domain.Bandas.Etiqueta import Etiqueta
from domain.Bandas.Respuesta import Respuesta
from domain.Bandas.Usuario import Usuario
from domain.EstadosMembresia.EstadoMembresia import EstadoMembresia
from domain.Roles.Rol import Rol


class Membresia:
    def __init__(self, usuario: Usuario, estado_membresia: EstadoMembresia,
                 respuestas: List[Respuesta], historial_estados: List[EstadoMembresia],
                 rol: Rol, etiquetas: List[Etiqueta]) -> None:
        self.usuario: Usuario = usuario
        self.estado_membresia: EstadoMembresia = estado_membresia
        self.respuestas: List[Respuesta] = respuestas
        self.historial_estados: List[EstadoMembresia] = historial_estados
        self.rol: Rol = rol
        self.etiquetas: List[Etiqueta] = etiquetas

    def agregar_etiqueta(self, etiqueta: Etiqueta) -> None:
        self.etiquetas.append(etiqueta)

    def remover_etiqueta(self, etiqueta: Etiqueta) -> None:
        self.etiquetas.remove(etiqueta)

    def cambiar_rol_a(self, rol: Rol) -> None:
        self.rol = rol

    def cambiar_estado_membresia_a(self, nuevo_estado_membresia: EstadoMembresia) -> None:
        self.estado_membresia.cambiar(nuevo_estado_membresia)




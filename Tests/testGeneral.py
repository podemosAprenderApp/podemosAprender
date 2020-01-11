import unittest
from datetime import datetime

from domain.Bandas.Usuario import Usuario
from domain.Reaccionables.Comentario import Comentario
from domain.Reaccionables.Expertise import Expertise
from domain.Reaccionables.Habilidad import Habilidad
from domain.Reaccionables.Interes import Interes
from domain.Reaccionables.Puntuacion import Puntuacion
from domain.Reaccionables.Reaccion import Reaccion
from domain.Reaccionables.TipoReaccion import TipoReaccion

if __name__ == '__main__':
    unittest.main()


class MyTestCase(unittest.TestCase):

    def __init__(self, *args, **kwargs):
        super(MyTestCase, self).__init__(*args, **kwargs)
        self.expertise = Expertise("Experto", [])
        self.rasgo = Interes([], "Desarrollo en Java", datetime.now())
        self.rasgo_validable = Habilidad([[]], "Vender Galletitas", datetime.now(), self.expertise)
        self.jorge = Usuario(datetime.now(), [self.rasgo], "Jorge", "jorgecapo", "estoNoEsUnHash")
        self.tobias = Usuario(datetime.now(), [self.rasgo_validable], "Tobias", "tobiascapo", "estoNoEsUnHash")
        self.meDivierte = TipoReaccion("Me Divierte")
        self.meEnoja = TipoReaccion("Me Enoja")
        self.reaccionEnojada = Reaccion(self.meEnoja, self.jorge)
        self.reaccionDeJorge = Reaccion(self.meDivierte, self.jorge)
        self.puntuacion = Puntuacion(True, Comentario(datetime.now(), "Que tipazo"),
                                     Comentario(datetime.now(), "Gracias che"), self.jorge)

    def test_something(self):
        self.assertEqual(True, True)  # Test inicial para subir el autoestima

    def test_rasgos(self):
        self.assertEqual("Desarrollo en Java", self.jorge.rasgos[0].texto)

    def test_reaccionar(self):
        self.jorge.rasgos[0].ser_reaccionado(self.reaccionDeJorge)
        self.assertEqual("Me Divierte", self.jorge.rasgos[0].reacciones[0].tipo.texto)

    def test_rasgo_reaccionar_varias_veces(self):
        for i in range(5):
            self.jorge.rasgos[0].ser_reaccionado(self.reaccionDeJorge)
        self.assertEqual(len(self.jorge.rasgos[0].reacciones), 1)

    def test_rasgo_reaccionar_y_cambiar_reaccion(self):
        self.jorge.rasgos[0].ser_reaccionado(self.reaccionDeJorge)
        self.jorge.rasgos[0].ser_reaccionado(self.reaccionEnojada)
        self.assertEqual("Me Enoja", self.jorge.rasgos[0].reacciones[0].tipo.texto)

    def test_rasgo_reaccionar_y_sacar_reaccion(self):
        self.jorge.rasgos[0].ser_reaccionado(self.reaccionDeJorge)
        self.jorge.rasgos[0].sacar_reaccion(self.reaccionDeJorge)
        self.assertEqual(len(self.jorge.rasgos[0].reacciones), 0)

    def test_rasgo_validable_puntuar(self):
        self.tobias.rasgos_validables()[0].expertise.ser_puntuado(self.puntuacion)
        self.assertEqual(True, self.tobias.rasgos_validables()[0].expertise.puntuaciones[0].es_positiva)

    def test_rasgo_validable_puntuar_y_sacar_puntuacion(self):
        self.tobias.rasgos_validables()[0].expertise.ser_puntuado(self.puntuacion)
        self.tobias.rasgos_validables()[0].expertise.ser_despuntuado(self.puntuacion)
        self.assertEqual(0, len(self.tobias.rasgos_validables()[0].expertise.puntuaciones))

    def test_rasgo_validable_puntuar_varias_veces(self):
        for i in range(5):
            self.tobias.rasgos_validables()[0].expertise.ser_puntuado(self.puntuacion)
        self.assertEqual(1, len(self.tobias.rasgos_validables()[0].expertise.puntuaciones))

    def test_comentar_puntuacion(self):
        self.tobias.rasgos_validables()[0].expertise.ser_puntuado(self.puntuacion)
        self.tobias.rasgos_validables()[0].expertise.puntuaciones[0].comentar(Comentario(datetime.now(), "Sos un groso"))
        self.tobias.rasgos_validables()[0].expertise.puntuaciones[0].responder(Comentario(datetime.now(), "Gracias capo"))
        self.assertEqual("Sos un groso",  self.tobias.rasgos_validables()[0].expertise.puntuaciones[0].comentario.texto)
        self.assertEqual("Gracias capo", self.tobias.rasgos_validables()[0].expertise.puntuaciones[0].respuesta.texto)


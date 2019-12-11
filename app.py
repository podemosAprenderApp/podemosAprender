from datetime import datetime
from http.server import HTTPServer, BaseHTTPRequestHandler

class Server(BaseHTTPRequestHandler):
	def do_GET(self):
		content = self.handle_http(200, 'text/html')
		self.wfile.write(content)
    
	def handle_http(self, status, content_type):
		self.send_response(status)
		self.send_header('Content-type', content_type)
		self.end_headers()
		return bytes(datetime.now().strftime('Hola, mundo! Es el %d/%m/%Y a las %H:%M:%S'), 'UTF-8')

HOST_NAME = 'localhost'
PORT_NUMBER = 80

httpd = HTTPServer((HOST_NAME, PORT_NUMBER), Server)
print('Servidor iniciado %s:%s' % (HOST_NAME, PORT_NUMBER))
httpd.serve_forever()
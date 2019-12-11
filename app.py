from datetime import datetime

def app(environ, start_response):
	data = bytes(datetime.now().strftime('Hola, mundo! Es el %d/%m/%Y a las %H:%M:%S'), 'UTF-8')
	start_response("200 OK", [
		("Content-Type", "text/plain"),
		("Content-Length", str(len(data)))
	])
	return iter([data])

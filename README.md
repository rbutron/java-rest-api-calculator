# Test BCP

Para ejecutarlo ud debera ejecutar el siguiente comando en su terminal, asegurece de tener Java 11 y Docker

```bash
$ docker-compose up
```

Este instalara todas las dependencias y ejecutara las pruebas unitarias

### Probar las implementaciones

Cuando este corriendo la imagen ejecute postman e implemente ese

POST http://localhost:5000/exchange-rate

```
{
    "originCurrency": "USD",
    "finalCurrency": "PEN",
    "value": "0",
    "date": "0"
}
```

O tambien podra ejecutar el comando en el terminal de esta manera

```bash
$ curl --location --request POST 'http://localhost:5000/exchange-rate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "originCurrency": "USD",
    "finalCurrency": "PEN",
    "value": "0",
    "date": "0"
}'
```

Use tambien el esqueleto presentado en la prueba:
GET http://localhost:5000/add?a=1&b=2

o ejecutelo de esta manera

```bash
$ curl --location --request GET 'http://localhost:5000/add?a=1&b=2'
```

Para poder revisar el desarrollo en la prueba revise la siguiente raiz:

Las peticiones entran por los router y se handlean por su constructor aqui un ejemplo:

- ExchangeRateRouter
- ExchangeRateHandler

siga este orden y podra ver la implementacion.

# NOTA
El cliente fue implementado en el puerto 3000

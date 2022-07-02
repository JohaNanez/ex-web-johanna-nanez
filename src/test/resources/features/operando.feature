#language: es

@testFeature
Característica: Operando
  Yo, como usuario
  Quiero,realizar diferentes operaciones
  Observando todos los resultados y algun mensaje de error si lo hubiese

  @test1
  Escenario: Suma
    Dado me encuentro en la pagina de la calculadora
    Cuando empiezo a sumar poniendo dos numeros: "2" y "10", luego presiono calcular y el resultado es "12"

  @test2
  Escenario: Resta
    Dado me encuentro en la pagina de la calculadora
    Cuando empiezo a restar poniendo dos numeros: "8" y "4", luego presiono calcular y el resultado es "4"

  @test3
  Escenario: Multiplicacion
    Dado me encuentro en la pagina de la calculadora
    Cuando empiezo a multiplicar poniendo dos numeros: "2" y "4", luego presiono calcular y el resultado es "8"

  @test4
  Escenario: Division
    Dado me encuentro en la pagina de la calculadora
    Cuando empiezo a dividir poniendo dos numeros: "8" y "4", luego presiono calcular y el resultado es "2"

  @test5
  Escenario: Concatenar
    Dado me encuentro en la pagina de la calculadora
    Cuando empiezo a concatenar poniendo dos numeros "4" y "5", luego presiono calcular y el resultado es "45"

  @test6
  Escenario: Alfanumerico errado
    Dado me encuentro en la pagina de la calculadora
    Cuando ingreso caracteres alfanumericos "a1" y "2", luego presiono calcular y el mensaje esperado es "Number 1 is not a number"

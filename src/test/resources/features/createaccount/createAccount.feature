# new feature
# Tags: optional

Feature: Crear una cuenta de usuario

  Background:
    Given El usuario se encuentra en el home de la tienda
    And el usuario navega a la pagina de login
    And el usuario ingresa un email aleatorio valido y confirma

  Scenario: Crear una cuenta satisfactoriamente
    When el usuario llena todos los campos y confirma
    Then el sistema mostrara un mensaje de bienvenida a la cuenta

  Scenario: Crear una cuenta con una contrasenia incorrecta
    When el usuario llena todos los campos usando como contrasenia "1234" y confirma
    Then el sistema mostrara un mensaje de error de contrasenia invalida
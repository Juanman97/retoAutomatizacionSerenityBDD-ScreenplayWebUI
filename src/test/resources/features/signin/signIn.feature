# new feature
# Tags: optional

Feature: Iniciar sesion en una cuenta
  yo como usuario
  quiero poder iniciar sesion en mi cuenta
  para poder administrar mis datos en la tienda

  Background:
    Given El usuario se encuentra en la vista principal de la tienda
    And el usuario navega al modulo de Sign In


  Scenario: Inicio de sesion exitoso
    When El usuario se registra en la pagina correctamente
    And el usuario cierra su sesion
    And el usuario ingresa sus credenciales de inicio correctas
    Then el sistema redirigira a la vista de cuenta de usuario

  Scenario: Inicio de sesion fallido
    When el usuario ingresa el email registrado con una contrasenia incorrecta
    Then el sistema mostrara un mensaje de autenticacion fallida
# new feature
# Tags: optional

Feature: Enviar un mensaje a la empresa
  Yo como usuario
  quiero poder enviar un mensaje a la empresa
  para poder comunicarme con ellos

  Background:
    Given El usuario se encuentra en la pagina principal de la tienda
    And el usuario navega a la pagina de contact us


  Scenario: Envio con formulario completo
    When el usuario llena el formulario completo y envia
    Then el sistema mostrara un mensaje de envio satisfactorio

  Scenario: Envio con email incorrecto
    When el usuario llena el formulario usando el email "emailInvalido"
    Then el sistema mostrara un mensaje de error
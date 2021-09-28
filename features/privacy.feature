Feature: Privacy page test

  Scenario: Privacy page
    Given estoy inicio
    When realizo click en el link privacidad
    Then el titulo debe ser Privacidad

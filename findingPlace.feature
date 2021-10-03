Feature: Finding housing

  Scenario Outline: Finding a housing

    Given estoy en la pagina de inicio
    When ingreso una ciudad <ciudad>
    And ingreso una llegada <llegada>
    And ingreso una salida <salida>
    And ingreso huespedes <huespedes>
    Then se muestran opciones de alojamiento

    Examples:

      | ciudad    | llegada   | salida    | huespedes |
      | "Colonia" | "13 oct." | "14 oct." | "3"       |


  Scenario Outline: Finding an experience

    Given estoy en experiencias
    When ingreso una ciudad <ciudad>
    Then se muestran experiencias

    Examples:

      | ciudad     |
      | "Hamburgo" |

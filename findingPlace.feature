Feature: Finding housing

  Scenario Outline: Finding a housing

    Given estoy en la pagina de inicio
    When ingreso una ciudad <ciudad>
    And ingreso una fecha <fecha>
    And ingreso huespedes
    And presiono en buscar
    Then se muestran opciones de alojamiento

    Examples:

      | ciudad    | fecha    |
      | "Colonia" | "Semana" |



  Scenario Outline: Finding an experience

    Given estoy en experiencias
    When ingreso una ciudad <ciudad>
    And presiono en buscar
    Then se muestran experiencias

    Examples:

      | ciudad     |
      | "Hamburgo" |

    Scenario: Show near places

      Given estoy en la pagina de inicio
      Then veo lugares cercanos
Feature: Spotify scenarios

  Scenario Outline: Access to premium

    Given ingreso spotify
    When voy a la seccion premium
    Then encuentro nombre <plan>

    Examples:

      | plan         |
      | "Individual" |
      | "Premium"    |
      | "Familiar"   |

  Scenario Outline: Spotify Emails Errors
    Given ingreso spotify
    And voy a registro
    When ingreso email <email>
    Then obtengo error <error>

    Examples:

      | email           | error                                                                                                  |
      | "fff"           | "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com" |
      | "test@test.com" | "Este correo electrónico ya está conectado a una cuenta. Inicia sesión."                               |
      | ""              | "Las direcciones de correo electrónico no coinciden."|



  Scenario Outline: Spotify legal
    Given ingreso spotify
    When voy a legal
    Then existen mensajes <puntos>

    Examples:

      | puntos                                        |
      | "Disfrutando Spotify"                         |
      | "Pagos, cancelaciones y periodo de reflexión" |
      | "Uso de nuestro servicio"                     |



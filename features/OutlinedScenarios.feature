Feature: Outlined Scenarios

  #Background:    (sirve para establecer un paso que será aplicable para todos los test, es decir, primero que nada, se ejecuta ese y luego el resto que corresponda, como por ej, acceder a spotify, y luego valido todo)
   #Given ingreso a spotify

  @compras
  Scenario Outline: Compras
    Given tengo <valor_inicial> dolares
    When gasto <valor_compra> dolares
    Then me sobran <valor_final> dolares

    Examples:
      | valor_inicial | valor_compra | valor_final |
      | 10            | 5            | 5           |
      | 20            | 8            | 12          |
      | 120           | 20           | 100         |

  @username
  Scenario Outline: Verificar username
    Given estoy logueado
    And estoy en pagina principal
    When busco nombre de usuario <username>
    Then recibo mensaje indicando <mensaje>

    Examples:

      | username  | mensaje                      |
      | "marcus"  | "No se encuentra"            |
      | "Rox123"" | "Nombre invalido"            |
      | "Maria"   | "nombre de usuario inactivo" |

  @spotify
  Scenario Outline: Spotify Registration Errors
    Given ingreso a spotify
    And voy a la pagina de registro
    When ingreso un email <email>
    And ingreso la confirmacion <confirmation>
    Then obtengo el error <error>

    Examples:

      | email                 | confirmation    | error                                                                                                  |
      | "fff"                 | "fff"           | "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com" |
      | "test@test.com"       | "test@test.com" | "Este correo electrónico ya está conectado a una cuenta. Inicia sesión."                               |
      | "testseleniumacademy7894@test.com" | "test@test.com" | "Las direcciones de correo electrónico no coinciden."                                                  |
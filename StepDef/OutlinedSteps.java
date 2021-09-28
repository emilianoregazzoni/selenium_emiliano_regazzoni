package intermedioCucumber2.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OutlinedSteps {

    Integer saldo = 0;

    @Given("tengo {int} dolares")
    public void tengo_dolares(Integer valorInicial) {
        saldo = valorInicial;
    }

    @When("gasto {int} dolares")
    public void gasto_dolares(Integer valorCompra) {
       saldo = saldo - valorCompra;
    }

    @Then("me sobran {int} dolares")
    public void me_sobran_dolares(Integer valorEsperado) {

        Assert.assertEquals(saldo,valorEsperado, "Se esperaba otro valor final");

    }

    /*
    @Given("estoy logueado")
    public void estoy_logueado() {
    }

    @Given("estoy en pagina principal")
    public void estoy_en_pagina_principal() {

    }

    @When("busco nombre de usuario {String}")
    public void busco_nombre_de_usuario(String string) {

    }

    @Then("recibo mensaje indicando {String}")
    public void recibo_mensaje_indicando_no_se_encuentra(String string) {

    }

     */

    }

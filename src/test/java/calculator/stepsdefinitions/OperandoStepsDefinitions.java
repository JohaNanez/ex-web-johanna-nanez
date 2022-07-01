package calculator.stepsdefinitions;

import calculator.steps.OperandoSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OperandoStepsDefinitions {

    private WebDriver driver;

    private Scenario scenario;



    @Before

    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();

    }

    @Before(order = 1)
        public void setScenario(Scenario scenario){
            this.scenario = scenario;
        }

    @After
        public void quitDriver(){
            driver.quit();
        }
    @Dado("me encuento en la pagina de la calculadora")
    public void me_encuento_en_la_pagina_de_la_calculadora() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        screenShot();
    }



        @Cuando("empiezo a operar poniendo dos numeros: {string} y {string}, luego presiono calcular y el resultado es {string}")
    public void empiezo_a_operar_poniendo_dos_numeros_y_luego_presiono_el_operador_en_este_caso(String string1, String string2, String string3) {
        OperandoSteps operandoSteps = new OperandoSteps(driver);
        operandoSteps.typeField1(string1);
        operandoSteps.typeField2(string2);
        operandoSteps.calcular();

           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String valorEsperado = operandoSteps.typeField3();
        Assertions.assertEquals("7", string3);
        screenShot();
    }
/*
    @Entonces("valido que deberia aparecer como {string}")
    public void valido_que_deberia_aparecer_como(String string) {

    }
    @Y("tambien valido la respuesta")
    public void tambien_valido_la_respuesta() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/

        public void screenShot(){
            byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            this.scenario.attach(evidencia, "image/png", "evidencias");
        }
}

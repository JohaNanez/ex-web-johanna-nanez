package calculator.stepsdefinitions;

import calculator.steps.OperandoSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OperandoStepsDefinitions {

    private WebDriver driver;

    private Scenario scenario;

    private OperandoSteps operandoSteps(WebDriver driver) {
        return new OperandoSteps(driver);
    }

    @Before

    public void setUp() {
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();

    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Dado("me encuentro en la pagina de la calculadora")
    public void me_encuento_en_la_pagina_de_la_calculadora() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        screenShot();
    }



    @Cuando("empiezo a sumar poniendo dos numeros: {string} y {string}, luego presiono calcular y el resultado es {string}")
    public void empiezo_a_operar_poniendo_dos_numeros_y_luego_presiono_el_operador_en_este_caso_suma(String num1, String num2, String num3) {
        OperandoSteps operandoSteps = new OperandoSteps(driver);
        operandoSteps.typeField1("");
        operandoSteps.typeField2("");
        operandoSteps.typeField1(num1);
        operandoSteps.typeField2(num2);
        Select drpCountry = operandoSteps.dropdownList();
        drpCountry.selectByValue("0");
        drpCountry.selectByVisibleText("Add");
        operandoSteps.CheckIntegerOnly();
        operandoSteps.calcular();
        screenShot();
        Assertions.assertEquals(operandoSteps.typeField3(),num3);
    }

    @Cuando("empiezo a restar poniendo dos numeros: {string} y {string}, luego presiono calcular y el resultado es {string}")
    public void empiezo_a_operar_poniendo_dos_numeros_y_luego_presiono_el_operador_en_este_caso_resta(String num1, String num2, String num3) {
        OperandoSteps operandoSteps = new OperandoSteps(driver);
        operandoSteps.typeField1("");
        operandoSteps.typeField2("");
        operandoSteps.typeField1(num1);
        operandoSteps.typeField2(num2);
        Select drpCountry = operandoSteps.dropdownList();
        drpCountry.selectByValue("1");
        drpCountry.selectByVisibleText("Subtract");
        operandoSteps.CheckIntegerOnly();
        operandoSteps.calcular();
        screenShot();
        Assertions.assertEquals(operandoSteps.typeField3(),num3);
    }

    @Cuando("empiezo a multiplicar poniendo dos numeros: {string} y {string}, luego presiono calcular y el resultado es {string}")
    public void empiezo_a_operar_poniendo_dos_numeros_y_luego_presiono_el_operador_en_este_caso_multiplicacion(String num1, String num2, String num3) {
        OperandoSteps operandoSteps = new OperandoSteps(driver);
        operandoSteps.typeField1("");
        operandoSteps.typeField2("");
        operandoSteps.typeField1(num1);
        operandoSteps.typeField2(num2);
        Select drpCountry = operandoSteps.dropdownList();
        drpCountry.selectByValue("2");
        drpCountry.selectByVisibleText("Multiply");
        operandoSteps.CheckIntegerOnly();
        operandoSteps.calcular();
        screenShot();
        Assertions.assertEquals(operandoSteps.typeField3(),num3);
    }

    @Cuando("empiezo a dividir poniendo dos numeros: {string} y {string}, luego presiono calcular y el resultado es {string}")
    public void empiezo_a_operar_poniendo_dos_numeros_y_luego_presiono_el_operador_en_este_caso_division(String num1, String num2, String num3) {
        OperandoSteps operandoSteps = new OperandoSteps(driver);
        operandoSteps.typeField1("");
        operandoSteps.typeField2("");
        operandoSteps.typeField1(num1);
        operandoSteps.typeField2(num2);
        Select drpCountry = operandoSteps.dropdownList();
        drpCountry.selectByValue("3");
        drpCountry.selectByVisibleText("Divide");
        operandoSteps.CheckIntegerOnly();
        operandoSteps.calcular();
        screenShot();
        Assertions.assertEquals(operandoSteps.typeField3(),num3);
    }

    @Cuando("empiezo a concatenar poniendo dos numeros {string} y {string}, luego presiono calcular y el resultado es {string}")
    public void empiezo_a_concatenar_poniendo_dos_numeros_y_luego_presiono_calcular(String num1, String num2, String num3) {
        OperandoSteps operandoSteps = new OperandoSteps(driver);
        operandoSteps.typeField1(num1+num2);
        //operandoSteps.typeField2(num2);
        Select drpCountry = operandoSteps.dropdownList();
        drpCountry.selectByValue("0");
        drpCountry.selectByVisibleText("Add");
        operandoSteps.CheckIntegerOnly();
        operandoSteps.calcular();
        screenShot();
        Assertions.assertEquals(operandoSteps.typeField3(),num3);
    }

    @Cuando("ingreso caracteres alfanumericos {string} y {string}, luego presiono calcular y el mensaje esperado es {string}")
    public void ingreso_alfanumerico_y_sale_error(String num1, String num2, String num3) {
        OperandoSteps operandoSteps = new OperandoSteps(driver);
        operandoSteps.typeField1(num1);
        operandoSteps.typeField2(num2);
        Select drpCountry = operandoSteps.dropdownList();
        drpCountry.selectByValue("0");
        drpCountry.selectByVisibleText("Add");
        operandoSteps.calcular();
        screenShot();
        Assertions.assertEquals(operandoSteps.getMessageError(),num3);
    }

    public void screenShot() {
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
}



package calculator.steps;

import calculator.page.OperandoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OperandoSteps {

    private WebDriver driver;

    //constructor
    public OperandoSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void typeField1(String num1) {
        WebElement userInputElement = this.driver.findElement(OperandoPage.number1Input);
        userInputElement.sendKeys(num1);
    }

    public void typeField2(String numero2) {
        WebElement userInputElement = this.driver.findElement(OperandoPage.number2Input);
        userInputElement.sendKeys(numero2);
    }

    public void CheckIntegerOnly() {
        WebElement userInputElement = this.driver.findElement(OperandoPage.checkintSelection);
        userInputElement.click();
    }

    public String getMessageError() {
        WebElement userInputElement = this.driver.findElement(OperandoPage.errorMsg);
        return userInputElement.getText();
    }

    public Select dropdownList (){
        Select drpCountry = new Select(driver.findElement(OperandoPage.dropdownListOperation));
        return drpCountry;
    }

    public void calcular() {
        this.driver.findElement(OperandoPage.calcularButton).click();

      WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(100));
      wait.until(ExpectedConditions.visibilityOfElementLocated(OperandoPage.numberAnswerInput));

    }

    public String typeField3(){
        WebElement userInputElement = this.driver.findElement(OperandoPage.numberAnswerInput);

        return this.driver.findElement(OperandoPage.numberAnswerInput).getAttribute("value");


    }

}


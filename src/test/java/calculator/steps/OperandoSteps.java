package calculator.steps;

import calculator.page.OperandoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OperandoSteps {

        private WebDriver driver;

        //constructor
        public OperandoSteps(WebDriver driver){

            this.driver = driver;
        }


        public void typeField1(String numero1){
            WebElement userInputElement = driver.findElement(OperandoPage.number1Input);
            userInputElement.sendKeys(numero1);
        }

        public void typeField2(String numero2){
            WebElement userInputElement = driver.findElement(OperandoPage.number2Input);
            userInputElement.sendKeys(numero2);
        }

        public void calcular(){
            this.driver.findElement(OperandoPage.calcularButton).click();
          //  return driver.findElement(OperandoPage.numberAnswerInput).getText();
        }

    public String typeField3(){
        return driver.findElement(OperandoPage.numberAnswerInput).getText();
    }

    }


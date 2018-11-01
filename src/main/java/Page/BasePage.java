package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {
    WebDriver driver;
    public BasePage(){
        driver = Init.getDriver();
        PageFactory.initElements(driver, this);
    }
}

package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*      add("Matchnine Cardla Slot Carbon Case чехол для iPhone 7 Plus/8 Plus, Black");
        add("Red Line iBox Blaze чехол для iPhone 7 Plus/8 Plus, Black");
        add("Клип-кейс Moshi Vitros для iPhone 8 Plus/7 Plus Clear-Black (99MO103033)");
        add("Simolina защитное 3D стекло для iPhone 7/8 Plus  черное");
        add("uBear GL14BL03-I8P защитное 3D стекло для Apple iPhone 8 Plus/ 7 Plus, Black");*/

public class OzonGoodPage extends BasePage {
    int timeOut = 25;

    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    WebElement addGoodToCart;

    public void addGoodToCart(){
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(addGoodToCart));
        addGoodToCart.click();
    }
}

package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzonSearchPage extends BasePage {
    private static final String patternForGoodsSearch = "//a[contains(text(),'%s')]";

    int timeOut = 25;

    @FindBy(xpath = "//span[contains(text(),'Корзина')]")
    WebElement cartButton;

    public void chooseGood(String nameOfGood){
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(String.format(patternForGoodsSearch,nameOfGood))));
        driver.findElement(By
                .xpath(String.format(patternForGoodsSearch,nameOfGood))).click();
    }
    public void goToCart(){
        cartButton.click();
    }
}

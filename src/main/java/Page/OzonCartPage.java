package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzonCartPage extends BasePage {
    private static final String patternForMenuWhenEntered = "//span[contains(text(),'%s')]";
    int timeOut = 25;

    @FindBy(xpath = "//span[contains(text(),'Корзина')]")
    WebElement cartButton;

    @FindBy(xpath = "//div[contains(text(),'Удалить')]")
    WebElement deleteAllFromCartButton;
    public void checkAddedGood(String good){
        try{
            driver.findElement(By.xpath(String.format(patternForMenuWhenEntered,good))).getText();
        }catch (org.openqa.selenium.NoSuchElementException e){
            System.out.printf("Данный товар не был добавлен: %s\n",good);
        }
    }
    public void deleteAllGoods(){
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//div[contains(text(),'Доставим')]")));
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(deleteAllFromCartButton));
        deleteAllFromCartButton.click();
    }
    public void checkEmptyness(){
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class = 'modal-container']")));
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//span[contains(text(),'Корзина')]")));
        cartButton.click();

        try{
            WebElement emptyCart = driver
                    .findElement(By.xpath(String.format(patternForMenuWhenEntered,"пуста")));
            new WebDriverWait(driver,timeOut)
                    .until(ExpectedConditions
                            .elementToBeClickable(emptyCart));
        }catch (org.openqa.selenium.NoSuchElementException e){
            System.out.println(" корзина не пуста ");
        }
    }

}

package Page;

import needsfortest.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OzonMainPage extends BasePage{
    private static final String patternForMenuAfterExit = "//span[contains(text(),'%s')]";
    int timeOut = 20;

    @FindBy(xpath = "//div[contains(text(),'Вход')]")
    WebElement openMyOZONtoEnter;

    @FindBy(xpath = "//span[contains(text(),'Выйти')]")
    WebElement getOpenMyOZONtoExitFromMainPage;

    @FindBy(xpath = "//div[contains(text(),'Мой OZON')]")
    WebElement menu;

    @FindBy(xpath = "//a[contains(text(),'Войти')]")
    WebElement enterByEmail;

    @FindBy(xpath = "//input[@type = 'text' and @class != 'search-input']")
    WebElement emailFor;

    @FindBy(xpath = "//input[@type = 'password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    WebElement enterButton;

    @FindBy(xpath = "//input[@class='search-input']")
    WebElement areaOfSearch;

    public void login(UserData user){
        try{
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions
                            .elementToBeClickable(menu));
            menu.click();
            openMyOZONtoEnter.click();
            new WebDriverWait(driver,timeOut)
                    .until(ExpectedConditions
                            .elementToBeClickable(enterByEmail));
        }catch(org.openqa.selenium.NoSuchElementException e){
            new WebDriverWait(driver,timeOut).until(ExpectedConditions.elementToBeClickable(By
                    .xpath("//span[contains(text(),'Мой OZON')]")));
            driver.findElement(By
                    .xpath(String
                            .format(patternForMenuAfterExit,"Мой OZON"))).click();
            driver.findElement(By
                    .xpath(String
                            .format(patternForMenuAfterExit,"Вход"))).click();
            new WebDriverWait(driver,timeOut)
                    .until(ExpectedConditions
                            .elementToBeClickable(enterByEmail));
        }catch (org.openqa.selenium.TimeoutException te){
            new WebDriverWait(driver,timeOut).until(ExpectedConditions.elementToBeClickable(By
                    .xpath("//span[contains(text(),'Мой OZON')]")));
            driver.findElement(By
                    .xpath(String
                            .format(patternForMenuAfterExit,"Мой OZON"))).click();
            driver.findElement(By
                    .xpath(String
                            .format(patternForMenuAfterExit,"Вход"))).click();
            new WebDriverWait(driver,timeOut)
                    .until(ExpectedConditions
                            .elementToBeClickable(enterByEmail));
        }
        enterByEmail.click();
        emailFor.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        enterButton.click();
    }

    public void find(String whatNeedToFined){
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(areaOfSearch));
        areaOfSearch.click();
        areaOfSearch.sendKeys(whatNeedToFined);
        areaOfSearch.sendKeys(Keys.ENTER);
    }

    public void logout(UserData user){
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//span[contains(text(),'Болг')]")));
        //patternForMenuAfterExit,user.getName()
        driver.findElement(By
                .xpath("//span[contains(text(),'Болг')]")).click();
        getOpenMyOZONtoExitFromMainPage.click();
    }
}

package Page;

import needsfortest.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class OzonPageObject extends BasePage{
    private static final String patternForMenuWhenEntered = "//span[contains(text(),'%s')]";
    private static final String patternForGoodsSearch = "//a[contains(text(),'%s')]";
    private static final String patternForMenuAfterExit = "//span[contains(text(),'%s')]";
    int timeOut = 25;

    @FindBy(xpath = "//div[contains(text(),'Вход')]")
    WebElement openMyOZONtoEnter;

    @FindBy(xpath = "//div[contains(text(),'Выйти')]")
    WebElement openMyOZONtoExitFromCartPage;

    @FindBy(xpath = "//span[contains(text(),'Выйти')]")
    WebElement getOpenMyOZONtoExitFromMainPage;

    @FindBy(xpath = "//div[contains(text(),'Мой OZON')]")
    WebElement menu;

    @FindBy(xpath = "//a[contains(text(),'Войти')]")
    WebElement enterByEmail;

    @FindBy(xpath = "//input[@type = 'text'][1]")
    WebElement email;

    @FindBy(xpath = "//input[@type = 'text' and @class != 'search-input']")
    WebElement emailFor;

    @FindBy(xpath = "//input[@type = 'password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    WebElement enterButton;

    @FindBy(xpath = "//input[@class='search-input']")
    WebElement areaOfSearch;

    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    WebElement addGoodToCart;

    @FindBy(xpath = "//span[contains(text(),'Корзина')]")
    WebElement cartButton;

    @FindBy(xpath = "//div[contains(text(),'Удалить')]")
    WebElement deleteAllFromCartButton;

//    String.format(patternForMenuWhenEntered,user.getName)

    public void firstTimeLogin(UserData user){
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(menu));
        menu.click();
        openMyOZONtoEnter.click();
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(enterByEmail));
        enterByEmail.click();
        email.sendKeys(user.getEmail());
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

    public void addGoodsToBusket(ArrayList<String> goods){
        for (String good:goods){
            addgood(good);
        }
        cartButton.click();
    }

    public void addgood(String good){
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(String.format(patternForGoodsSearch,good))));
        driver.findElement(By
                .xpath(String.format(patternForGoodsSearch,good))).click();
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(addGoodToCart));
        addGoodToCart.click();
        driver.navigate().back();
    }

    public void checkGoodsInCart(ArrayList<String> goods){
        for(String good:goods){
            checkGood(good);
        }
    }

    public void checkGood(String good){
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

    public void exitFromMainPage(UserData user){
        driver.navigate().to("https://www.ozon.ru/");
        new WebDriverWait(driver,timeOut)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//span[contains(text(),'Болг')]")));
        driver.findElement(By
                .xpath("//span[contains(text(),'Болг')]")).click();
        getOpenMyOZONtoExitFromMainPage.click();
    }

    public void loginAfterExit(UserData user){
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
        enterByEmail.click();

        emailFor.sendKeys(user.getEmail());
        password.sendKeys(user.getPassword());
        enterButton.click();
    }

    public void checkEmptyCart(){
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

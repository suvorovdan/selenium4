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

    OzonMainPage mainPage = new OzonMainPage();
    OzonSearchPage searchPage = new OzonSearchPage();
    OzonCartPage cartPage = new OzonCartPage();
    OzonGoodPage goodPage = new OzonGoodPage();

    public void loginOnMainPage(UserData user){
        mainPage.login(user);
    }

    public void findOnMainPage(String whatNeedToFined){
        mainPage.find(whatNeedToFined);
    }

    public void addGoodsToBusket(ArrayList<String> goods){
        for (String good:goods){
            addgood(good);
        }
        searchPage.goToCart();
    }

    public void addgood(String good){
        searchPage.chooseGood(good);
        goodPage.addGoodToCart();
        driver.navigate().back();
    }

    public void checkGoodsInCart(ArrayList<String> goods){
        for(String good:goods){
            checkGood(good);
        }
    }

    public void checkGood(String good){
        cartPage.checkAddedGood(good);
    }

    public void deleteAllGoods(){
        cartPage.deleteAllGoods();
    }

    public void exitFromMainPage(UserData user){
        driver.navigate().to("https://www.ozon.ru/");
        mainPage.logout(user);
    }

    public void loginAfterExit(UserData user){
        mainPage.login(user);
    }

    public void checkEmptyCart(){
        cartPage.checkEmptyness();
    }

}

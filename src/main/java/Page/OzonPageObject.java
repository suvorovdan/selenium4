package Page;

import io.qameta.allure.Step;
import needsfortest.UserData;

import java.util.ArrayList;

public class OzonPageObject extends BasePage{

    OzonMainPage mainPage = new OzonMainPage();
    OzonSearchPage searchPage = new OzonSearchPage();
    OzonCartPage cartPage = new OzonCartPage();
    OzonGoodPage goodPage = new OzonGoodPage();

    @Step("Вход в учётную запись через почту {0}")
    public void loginOnMainPage(UserData user){
        mainPage.login(user);
    }
    @Step("Поиск товара '{0}'")
    public void findOnMainPage(String whatNeedToFined){
        mainPage.find(whatNeedToFined);
    }
    @Step("Добавление товаров в корзину: {0}")
    public void addGoodsToBusket(ArrayList<String> goods){
        for (String good:goods){
            addgood(good);
        }
        searchPage.goToCart();
    }
    @Step("Выбор товара {0} и добавление его в корзину")
    public void addgood(String good){
        searchPage.chooseGood(good);
        goodPage.addGoodToCart();
        driver.navigate().back();
    }
    @Step("Проверка товаров на соответствие в корзине")
    public void checkGoodsInCart(ArrayList<String> goods){
        for(String good:goods){
            checkGood(good);
        }
    }
    @Step("Проверка товара {0}")
    public void checkGood(String good){
        cartPage.checkAddedGood(good);
    }
    @Step("Нажатие кнопки удалить всё")
    public void deleteAllGoods(){
        cartPage.deleteAllGoods();
    }
    @Step("Выход из учётной записи")
    public void exitFromMainPage(UserData user){
        driver.navigate().to("https://www.ozon.ru/");
        mainPage.logout(user);
    }
    @Step("Повторный вход в учётную запись через почту {0}")
    public void loginAfterExit(UserData user){
        mainPage.login(user);
    }
    @Step("Проверка пустоты корзины")
    public void checkEmptyCart(){
        cartPage.checkEmptyness();
    }

}

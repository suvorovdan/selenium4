package stepdefs;

import Page.OzonPageObject;
import cucumber.api.PendingException;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import needsfortest.UserData;

import java.util.ArrayList;

public class MyStepdefs {
    UserData user = new UserData("olaf92481g@rambler.ru","olaf92481GQO","Болг");
    ArrayList<String> goods = new ArrayList<String>(){{
        add("Чехол Black Rock Flex Carbon Case для Apple iPhone 8 Plus / 7 Plus / 6/6S Plus, цвет: черный");//
        add("Deppa Air Case чехол для Apple iPhone 7 Plus/8 Plus, Black");//
        add("Waves Protect чехол для iPhone 7 Plus/8 Plus, Black");//
        add("Matchnine Cardla Slot Carbon Case чехол для iPhone 7 Plus/8 Plus, Black");
        add("Apple Leather Case чехол для iPhone 7 Plus/8 Plus, Black");
    }};

    OzonPageObject ozon = new OzonPageObject();

    @Когда("^нажимаю кнопку вход, выбираю вход через почту,ввожу логин и пароль и нажимаю кнопку войти$")
    public void нажимаюКнопкуВходВыбираюВходЧерезПочтуВвожуЛогинИПарольИНажимаюКнопкуВойти() throws Throwable {
        ozon.loginOnMainPage(user);
    }

    @Тогда("^ввожу в строку поиска \"(.*)\"$")
    public void ввожуВСтрокуПоиска(String arg0) throws Throwable {
        ozon.findOnMainPage(arg0);
    }

    @Когда("^добавляю товары в корзину$")
    public void добавляюТоварыВКорзину() throws Throwable {
        ozon.addGoodsToBusket(goods);
    }

    @Тогда("^проверяю все ли товары добавлены$")
    public void проверяюВсеЛиТоварыДобавлены() throws Throwable {
        ozon.checkGoodsInCart(goods);
    }

    @Когда("^удаляю все добавленные товары из корзины$")
    public void удаляюВсеДобавленныеТоварыИзКорзины() throws Throwable {
        ozon.deleteAllGoods();
    }

    @И("^выхожу из учётной записи$")
    public void выхожуИзУчётнойЗаписи() throws Throwable {
        ozon.exitFromMainPage(user);
    }

    @Тогда("^заново вхожу в учётную запись$")
    public void зановоВхожуВУчётнуюЗапись() throws Throwable {
        ozon.loginAfterExit(user);
    }

    @И("^проверяю, что корзина пуста$")
    public void проверяюЧтоКорзинаПуста() throws Throwable {
        ozon.checkEmptyCart();
    }
}

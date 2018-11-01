import Page.Init;
import Page.OzonPageObject;
import needsfortest.UserData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class OzonePageObjectTest {
    UserData user = new UserData("olaf92481g@rambler.ru","olaf92481GQO","Болг");
    ArrayList<String> goods = new ArrayList<String>(){{
        add("Чехол Black Rock Flex Carbon Case для Apple iPhone 8 Plus / 7 Plus / 6/6S Plus, цвет: черный");//
        add("Deppa Air Case чехол для Apple iPhone 7 Plus/8 Plus, Black");//
        add("Waves Protect чехол для iPhone 7 Plus/8 Plus, Black");//
        add("Matchnine Cardla Slot Carbon Case чехол для iPhone 7 Plus/8 Plus, Black");
        add("Apple Leather Case чехол для iPhone 7 Plus/8 Plus, Black");
    }};



    @Before
    public void start(){
        Init.startUp();
    }

    @After
    public void end(){ Init.tearDown();}


    @Test
    public void TestPageObject(){
        OzonPageObject ozon = new OzonPageObject();
        ozon.loginOnMainPage(user);
        ozon.findOnMainPage("iPhone 7 Plus/8 Plus Black");
        ozon.addGoodsToBusket(goods);
        ozon.checkGoodsInCart(goods);
        ozon.deleteAllGoods();
        ozon.exitFromMainPage(user);
        ozon.loginAfterExit(user);
        ozon.checkEmptyCart();
    }
}

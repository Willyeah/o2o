package com.hnist.yeah.dao;

import com.hnist.yeah.BaseTest;
import com.hnist.yeah.entity.PersonInfo;
import com.hnist.yeah.entity.Shop;
import com.hnist.yeah.entity.Area;
import com.hnist.yeah.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private  ShopDao shopDao;

    @Test
    public void testInsetShop() {
        Shop shop = new Shop();
        PersonInfo  owner = new PersonInfo();
        Area area= new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setPhone("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int i = shopDao.insertShop(shop);
        System.out.println(i);

    }
    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(1L);

        shop.setShopDesc("testDexe");
        shop.setPhone("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int i = shopDao.updateShop(shop);
        System.out.println(i);
    }
}

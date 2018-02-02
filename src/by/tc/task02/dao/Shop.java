package by.tc.task02.dao;

import java.util.HashMap;
import java.util.Map;


public class Shop {
    private Map<SportEquipment, Integer> goods;
    private Map<SportEquipment, Integer> goodsInRent;

    public Shop() {
        goods = new HashMap<>();
        goodsInRent = new HashMap<>();
    }

    public Shop(Map<SportEquipment, Integer> goods) {
        this.goods = goods;
        goodsInRent = new HashMap<>();
    }

    public Map<SportEquipment, Integer> getGoods() {
        return goods;
    }

    public Map<SportEquipment, Integer> getRentGoods() {
        return goodsInRent;
    }
}

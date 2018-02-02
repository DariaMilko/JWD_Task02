package by.tc.task02.dao.impl;

import static by.tc.task02.service.impl.SportEquipmentRequestImpl.constructMapFromFile;
import static by.tc.task02.service.impl.SportEquipmentRequestImpl.printGoodsInfo;
import static by.tc.task02.service.impl.SportEquipmentRequestImpl.rentItem;

import java.io.IOException;
import java.util.Map;

import by.tc.task02.dao.Shop;
import by.tc.task02.dao.SportEquipment;
import by.tc.task02.entity.Category;
import by.tc.task02.service.RentUnit;
import by.tc.task02.sources.ConstantStrings;

public class SportEquipmentImpl {
	
	public void call() {       
		Map<SportEquipment, Integer> map;
		Shop shop;
		String filePath = ConstantStrings.FILEPATH;
		try {
			map = constructMapFromFile(filePath);
			shop = new Shop(map);
		} catch (IOException e) {
			System.out.println(ConstantStrings.GOODS_NOT_FOUND + filePath);;
            shop = new Shop();
        }

        RentUnit rentUnit = new RentUnit();
        SportEquipment sportEquipment1 = new SportEquipment(Category.TENNIS, "racket", 29.25);
        SportEquipment sportEquipment2 = new SportEquipment(Category.FOOTBALL, "shoes", 49.10);

        rentItem(sportEquipment1, shop, rentUnit);
        rentItem(sportEquipment2, shop, rentUnit);
        rentItem(sportEquipment2, shop, rentUnit);

        printGoodsInfo(shop.getGoods(), 1);
        printGoodsInfo(shop.getRentGoods(), 2);
    }
}
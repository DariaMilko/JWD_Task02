package by.tc.task02.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.tc.task02.dao.Shop;
import by.tc.task02.dao.SportEquipment;
import by.tc.task02.entity.Category;
import by.tc.task02.service.RentUnit;
import by.tc.task02.sources.ConstantStrings;

public class SportEquipmentRequestImpl {
	
	public static Map<SportEquipment, Integer> constructMapFromFile(String fileName) throws IOException {
		Map<SportEquipment, Integer> mapOfGoods = new HashMap<>();
		Path pathToFileOfGoods = Paths.get(ConstantStrings.USER_DIR + 
				ConstantStrings.SRC + ConstantStrings.FILEPATH);
		List<String> readingLinesInGoodsFile = Files.readAllLines(pathToFileOfGoods, StandardCharsets.UTF_8);
        for (String currentLine : readingLinesInGoodsFile) {
        	String[] split = currentLine.split(ConstantStrings.SPLIT_SYMBOL);
        	mapOfGoods.put(new SportEquipment(Category.valueOf(split[0]), split[1], 
        			Double.parseDouble(split[2])),Integer.parseInt(split[3]));
        	}
        return mapOfGoods;
        }

    public static void rentItem(SportEquipment equipment, Shop shop, RentUnit rentUnit) {
        if (shop.getGoods().containsKey(equipment)) {               	 
            Integer quantityOfRequestedGood = shop.getGoods().get(equipment);
            if (quantityOfRequestedGood != 0) {       
                if (rentUnit.addItem(equipment)) {           
                    shop.getGoods().replace(equipment, --quantityOfRequestedGood);
                    if (shop.getRentGoods().containsKey(equipment)) {	
                        quantityOfRequestedGood = shop.getRentGoods().get(equipment);
                        shop.getRentGoods().put(equipment, ++quantityOfRequestedGood);
                    } else {
                        shop.getRentGoods().put(equipment, 1);   
                    }
                }
                else  System.out.println(ConstantStrings.OUT_OF_GOODS);
            }
        }
    }

    public static void printGoodsInfo(Map<SportEquipment, Integer> mapOfGoods, int goodsType) {
        String infoAboutGoods;
        switch (goodsType) {
            case 1:
            	infoAboutGoods = ConstantStrings.GOODS_IN_STOCK;
                break;
            case 2:
                infoAboutGoods = ConstantStrings.GOODS_IN_RENT;
                break;
            default:
                infoAboutGoods = ConstantStrings.DEFAULT_GOODS;
        }
        if (!mapOfGoods.isEmpty()) {
            System.out.println(infoAboutGoods);
            mapOfGoods.forEach((requestedGood, quantityOfRequestedGood) -> System.out.println(requestedGood.toString() + ConstantStrings.SEPARATOR + quantityOfRequestedGood));
        } else {
            System.out.println(infoAboutGoods + 0);
        }
    }
}

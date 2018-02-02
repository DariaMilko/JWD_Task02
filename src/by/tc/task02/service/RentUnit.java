package by.tc.task02.service;

import by.tc.task02.dao.SportEquipment;
import by.tc.task02.sources.ConstantStrings;

public class RentUnit {
    private SportEquipment[] units;

    public RentUnit() {
        units = new SportEquipment[ConstantStrings.MAX_NUMBER_OF_GOODS_FOR_RENT];
    }

    public boolean addItem(SportEquipment item) {
        for (int i = 0; i < getUnits().length; i++) {
            if (getUnits()[i] == null) {
                getUnits()[i] = item;
                return true;
            }
        }
        return false;
    }

    public SportEquipment[] getUnits() {
        return units;
    }
}

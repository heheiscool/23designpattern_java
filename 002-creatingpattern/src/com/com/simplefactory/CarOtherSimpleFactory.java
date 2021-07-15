package com.com.simplefactory;

import java.util.HashMap;
import java.util.Map;

public class CarOtherSimpleFactory {
    //利用泛型做了一些调整，可以跟if-else比对，利用泛型更复合开闭原则的设计思想
    private static ICar iCar = null;
    public static final Map<String,ICar> theTyep = new HashMap<>();

    static {
        theTyep.put("TOP",new TopCar());
        theTyep.put("MID",new TopCar());
        theTyep.put("LOW",new TopCar());
    }

    public static ICar create(String mark){
        ICar iCar = null;
        iCar = theTyep.get(mark);
        return iCar;
    }
}

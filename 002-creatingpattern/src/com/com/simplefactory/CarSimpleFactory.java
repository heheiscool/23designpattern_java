package com.com.simplefactory;

public class CarSimpleFactory {

    public static final String TOPTYPE = "TOP";
    public static final String MIDTYPE = "MID";
    public static final String LOWTYPE = "LOW";

    public static ICar create(String mark){
        ICar iCar = null;
        if(mark.equals(TOPTYPE)){
            iCar = new TopCar();
        }
        if(mark.equals(MIDTYPE)){
            iCar = new MidCar();
        }
        if(mark.equals(LOWTYPE)){
            iCar = new LowCar();
        }
        return iCar;
    }
}

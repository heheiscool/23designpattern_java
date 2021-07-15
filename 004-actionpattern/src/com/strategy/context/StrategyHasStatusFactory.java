package com.strategy.context;

public class                                                                                                                                                                                                                    StrategyHasStatusFactory {

    public static Strategy getStrategy(String type){
        if(type == null || type.isEmpty()){
            throw new IllegalArgumentException();
        }
        if(type.equals("A")){
            return new StrategyA();
        }
        if(type.equals("B")){
            return new StrategyB();
        }
        if(type.equals("C")){
            return new StrategyC();
        }
        return null;
    }
}

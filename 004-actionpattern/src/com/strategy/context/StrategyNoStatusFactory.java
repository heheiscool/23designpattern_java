package com.strategy.context;

import java.util.HashMap;
import java.util.Map;

public class StrategyNoStatusFactory {
    private static final Map<String,Strategy> strategies = new HashMap<>();
    static {
        strategies.put("A",new StrategyA());
        strategies.put("B",new StrategyB());
        strategies.put("C",new StrategyC());
    }

    public static Strategy getStrategy(String type){
        if(type == null || type.isEmpty()){
            throw new IllegalArgumentException();
        }
        return strategies.get(type);
    }
}

package com.strategy.context;

import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        System.out.println("请出入策略类型:");
        Scanner scanner = new Scanner(System.in);
        Strategy strategy = null;
        String type = null;
        while ( scanner.hasNext()){
            type = scanner.next();
            System.out.println("输入type类型为："+ type);
            if(type.equals("exit")) break;
            strategy = StrategyNoStatusFactory.getStrategy(scanner.next());
            if(strategy == null) break;
            strategy.update();
            System.out.println("------------");
        }
    }
}

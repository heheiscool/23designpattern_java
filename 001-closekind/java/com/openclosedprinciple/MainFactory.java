package com.openclosedprinciple;

import com.openclosedprinciple.factory.HeroFactory;
import com.openclosedprinciple.ploymophic.SonTest;
import com.openclosedprinciple.ploymophic.Test;
import com.openclosedprinciple.reflection.HeroReflectFactory;

import java.util.Scanner;

public class MainFactory {
    public static void main(String[] args) throws Exception {
        //工厂模式使得main方法稳定了
        String name = MainFactory.getPlayerInput();
        HeroISkill heroISkill = HeroReflectFactory.getHero(name);   //通过反射工厂
        MainFactory.heroAction(heroISkill);

    }

    private static String  getPlayerInput(){
        System.out.println("======Enter a Hero's name:======");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }

    private static void heroAction(HeroISkill heroISkill){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入技术动作:");
        while (true){
            String input = scanner.next();
            if ("w".equals(input)) {
                heroISkill.a();
            } else if ("s".equals(input)) {
                heroISkill.s();
            } else if ("a".equals(input)) {
                heroISkill.a();
            } else if ("d".equals(input)) {
                heroISkill.d();
            } else
                return;
        }
    }
}

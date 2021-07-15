package com.openclosedprinciple;

import com.openclosedprinciple.hero.Diana;
import com.openclosedprinciple.hero.Irelia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = Main.getPlayerInput();
        HeroISkill hero = null;
        if(name!= null){
            switch (name){
                case "Diana":
                    hero = new Diana();
                    break;
                case "Irelia":
                    hero = new Irelia();
                    break;
                default:
                    return;
            }
            System.out.println("@@@@@@@");
        } else {
           return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入技术动作:");
        while (true){
            String input = scanner.next();
            if ("w".equals(input)) {
                hero.a();
            } else if ("s".equals(input)) {
                hero.s();
            } else if ("a".equals(input)) {
                hero.a();
            } else if ("d".equals(input)) {
                hero.d();
            } else
                break;
        }
    }

    private static String  getPlayerInput(){
        System.out.println("======Enter a Hero's name:======");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }
}

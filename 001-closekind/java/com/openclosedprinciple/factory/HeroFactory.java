package com.openclosedprinciple.factory;

import com.openclosedprinciple.HeroISkill;
import com.openclosedprinciple.hero.Diana;
import com.openclosedprinciple.hero.Irelia;

public class HeroFactory {
    public static HeroISkill getHero(String name) throws Exception {
        HeroISkill heroISkill;
        switch (name){
            case "Diana":
                heroISkill = new Diana();
                break;
            case "Irelia":
                heroISkill = new Irelia();
                break;
            default:
                throw new Exception();
        }
        return heroISkill;
    }

}

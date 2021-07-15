package com.openclosedprinciple.reflection;

import com.openclosedprinciple.HeroISkill;
import com.openclosedprinciple.hero.Diana;
import com.openclosedprinciple.hero.Irelia;

public class HeroReflectFactory {
    public static HeroISkill getHero(String name) throws Exception {
        HeroISkill heroISkill = null;
        String clazzName = "com.openclosedprinciple.hero."+name;
        Class<?> clazz = Class.forName(clazzName);  //通过反射机制增加了代码的稳定性
        HeroISkill heroISkill1 = (HeroISkill) clazz.newInstance();
        return heroISkill1;
    }

}

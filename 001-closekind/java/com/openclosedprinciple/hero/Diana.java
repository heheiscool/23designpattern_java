package com.openclosedprinciple.hero;

import com.openclosedprinciple.HeroISkill;

public class Diana implements HeroISkill {
    public void w(){
        System.out.println(this.getClass().getName().toString()+"'s skill is: w");
    }
    public void s(){
        System.out.println(this.getClass().getName().toString()+"'s skill is: s");
    }
    public void a(){
        System.out.println(this.getClass().getName().toString()+"'s skill is: a");
    }
    public void d(){
        System.out.println(this.getClass().getName().toString()+"'s skill is: d");
    }
}

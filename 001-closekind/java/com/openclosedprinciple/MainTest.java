package com.openclosedprinciple;

import com.openclosedprinciple.ploymophic.SonTest;
import com.openclosedprinciple.ploymophic.Test;

public class MainTest {
    public static void main(String[] args) {
        //本段代码体现多态
        Test test = new SonTest();
        System.out.println(test.book);
        test.base();
        test.test();
    }
}

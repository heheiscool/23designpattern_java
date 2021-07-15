package com.interfaces;

public class OneInterfaceImp implements OneInterface {
    @Override
    public String hello(String str) {
        return "The World of input from interface \"OneInterface\" is:\n"+str;
    }
}

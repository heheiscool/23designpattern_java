package com.factorymethod;

public class ConcreateOtherCreator implements Creator {

    @Override
    public <T extends Product> T factory(Class<T> tClass) {
        return null;
    }

    @Override
    public <T extends Product> T factory(String productType) {
        Product product =null;
        product = ChoiceFactory.createProuct(productType);
        return (T) product;
    }

}

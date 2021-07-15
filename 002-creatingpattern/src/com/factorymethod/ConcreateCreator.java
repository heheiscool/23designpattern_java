package com.factorymethod;

public class ConcreateCreator implements Creator {
    @Override
    public <T extends Product> T factory(Class<T> tClass) {
        Product product = null;
        try {
            product = (Product)Class.forName(tClass.getName()).newInstance();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) product;
    }

    @Override
    public <T extends Product> T factory(String productType) {
        return null;
    }
}

package com.wallet.lessblood;

        import org.jboss.arquillian.container.test.api.Deployment;
        import org.jboss.arquillian.junit.Arquillian;
        import org.jboss.shrinkwrap.api.ShrinkWrap;
        import org.jboss.shrinkwrap.api.asset.EmptyAsset;
        import org.jboss.shrinkwrap.api.spec.JavaArchive;
        import org.junit.Test;
        import org.junit.runner.RunWith;

        import static org.junit.Assert.*;

public class HelloTest {


    @Test
    public void test() {
        Hello hello = new Hello();
        System.out.println(hello.sayHello("+++++======"));
    }
}

package Ejemplo2.com.org.Frutas;

import com.google.common.eventbus.Subscribe;

public class FruitEaterListener {
    @Subscribe
    public void eat(Fruit fruit) throws RawFruitException {
        System.out.println("eat(Fruit " + fruit +")");
    }  
     
    @Subscribe
    public void eat(Apple apple) {
        System.out.println("eat(" + apple +")");
    } 
}

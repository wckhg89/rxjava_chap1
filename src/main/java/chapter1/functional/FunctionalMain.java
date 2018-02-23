package chapter1.functional;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by guppy.kang on 2018. 2. 22.
 * email : guppy.kang@kakaocorp.com
 */
public class FunctionalMain {

    private static List<Fruit> fruits = ImmutableList.<Fruit>builder()
            .add(new Fruit("banana", "yellow", 1))
            .add(new Fruit("mango", "yellow", 2))
            .add(new Fruit("apple", "red", 3))
            .add(new Fruit("orange", "orange", 4))
            .build();


    public static void main (String args[]) {

        fruits.stream().map(fruit -> fruit.getName()).forEach(System.out::println);

        Fruit.extractMaxFruitFunctional(fruits);

        List<Fruit> appleList = Fruit.extractFruitList(fruits, new Predicate<Fruit>() {
            @Override
            public boolean test(Fruit fruit) {
                return "apple".equals(fruit.getName());
            }
        });

        Fruit.extractFruitList(fruits, fruit1 -> "apple".equals(fruit1.getName()));


        List<Fruit> redList = Fruit.extractFruitList(fruits, new Predicate<Fruit>() {
            @Override
            public boolean test(Fruit fruit) {
                return "red".equals(fruit.getColor());
            }
        });

        Fruit.extractFruitList(fruits, fruit2 -> "red".equals(fruit2.getColor()));




    }
}

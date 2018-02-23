package chapter1.functional;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by guppy.kang on 2018. 2. 22.
 * email : guppy.kang@kakaocorp.com
 */
class Fruit{
    private String name;
    private String color;
    private int count;

    Fruit(String name, String color, int count){
        this.name = name;
        this.color = color;
        this.count = count;
    }

    String getName(){
        return this.name;
    }

    String getColor(){
        return this.color;
    }


    // AS-IS
    public static Fruit extractMaxFruitNonFunctional (List<Fruit> fruits) {
        return Collections.max(fruits, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    // TO-BE
    public static Fruit extractMaxFruitFunctional (List<Fruit> fruits) {
        return Collections.max(fruits, (o1, o2) -> {return o1.name.compareTo(o2.name);});
    }

    // AS-IS
    public static List<Fruit> extractApple(List<Fruit> fruits){
        List<Fruit> resultList = Lists.newArrayList();
        for(Fruit fruit : fruits){
            if("apple".equals(fruit.getName())){
                resultList.add(fruit);
            }
        }

        return resultList;
    }

    // AS-IS
    public static List<Fruit> extractRed(List<Fruit> fruits){
        List<Fruit> resultList = Lists.newArrayList();
        for(Fruit fruit : fruits){
            if("red".equals(fruit.getColor())){
                resultList.add(fruit);
            }
        }

        return resultList;
    }

    // TO-BE
    static List<Fruit> extractFruitList(List<Fruit> fruits, Predicate<Fruit> predicate){
        List<Fruit> resultList = Lists.newArrayList();
        for(Fruit fruit : fruits){
            if(predicate.test(fruit)){
                resultList.add(fruit);
            }
        }

        return resultList;
    }


}

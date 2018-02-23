package chapter1.rxjava;

import io.reactivex.Observable;

/**
 * Created by guppy.kang on 2018. 2. 22.
 * email : guppy.kang@kakaocorp.com
 */
public class FirstExample {

    public void emit () {
        Observable.just("Hello", "RxJava 2!!")
                .subscribe(data -> System.out.println(data));
                //.subscribe(System.out::println);
    }

    public static void main (String args[]) {
        FirstExample demo = new FirstExample();
        demo.emit();
    }


}

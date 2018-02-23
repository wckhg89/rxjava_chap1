
# Chapter 1 - 리엑티브 프로그래밍 소개


### 1.1 리액티브 프로그래밍

- 리액티브 프로그래밍은 데이터 흐름과 전달에 관한 프로그래밍 패러다임

- 명령형 프로그래밍

    - 프로그래머가 작성한 코드가 정해진 절차에 따라 **순서대로** 실행

- 리액티브 프로그래밍

    - 데이터 흐름을 먼저 정의하고 데이터가 변경되었을 때 연관되는 함수나 수식이 업데이트


### 1.1.1 자바 언어와 리액티브 프로그래밍

- 자바 언어와 리액티브 프로그래밍의 관계

    - 기존 pull 방식의 프로그래밍 개념을 push 방식의 프로그래밍 개념으로 바꾼다.

    - 함수형 프로그래밍의 지원을 받는다.

- 자바 언어는 객체지향 프로그래밍 언어 (pull 방식)

- 리액티브 프로그래밍 에서는 데이터의 변화가 발생 했을 때 변경이 발생한 곳에서 새로운 데이터를 보내(push) 준다.

- 리액티브 프로그래밍을 위해서는 함수형 프로그래밍이 필요하다.

    - 리액티브 프로그래밍은 옵저버 패턴 기반으로 구현되어 있다.

    - 옵저버 패턴은 멀티 스레드 환경에서 데드락, 동기화 문제를 회피하기에 함수형 프로그래밍이 적합하다.

    - 함수형 프로그래밍은 부수 효과가 없다.

        - 부수 효과 : 같은 자원에 여러 스레드 경쟁 조건에 빠지게 되었을 때 예측할 수 없는 잘못된 결과가 나오는 효과

    - 함수형 프로그래밍은 순수 함수를 지향한다. 따라서 멀티 스레드 환경에서도 안전하다.


### (추가) 자바8 함수형 프로그래밍

- 참고 링크

    - http://multifrontgarden.tistory.com/124?category=471239

    - https://skyoo2003.github.io/post/2016/11/09/java8-lambda-expression

- 함수형 프로그래밍

    - 함수형 프로그래밍은 함수의 입력만을 의존하여 출력을 만드는 구조로 외부에 상태를 변경하는 것을 지양하는 패러다임으로 부작용(Side-effect) 발생을 최소화 하는 방법론.

    - 함수형 프로그래밍에서는 다음의 조건을 만족시켜야 한다.

        - 순수한 함수 (Pure Function)

            ```

            - 부작용 (Side-effect)가 없는 함수로 함수의 실행이 외부의 상태를 변경시키지 않는 함수를 의미한다.

            - 순수한 함수는 멀티 쓰레드 환경에서도 안전하고, 병렬처리 및 계산이 가능하다.

            - 오직 입력에 의해서만 출력이 정해지고, 환경이나 상태에 영향을 받아서는 안된다는 의미이다.

            ```

        - 익명 함수 (Annonymous Function)

            ```

            - 이름이 없는 함수를 정의할 수 있어야 한다.

            - 이러한 익명 함수는 대부분의 프로그래밍 언어에서 ‘람다식’으로 표현한다.

            ```

        - 고계 함수 (Higher-order Function)

            ```

            - 함수를 다루는 상위의 함수로 함수형 언어에서는 함수도 하나의 값으로 취급한다.

            - 함수의 인자로 함수를 전달할 수 있는 특성이 있다.

            - 이러한 함수를 일급 객체 (a.k.a 일급 함수) 로 간주한다.

            ```

    - 자바에서의 함수형 프로그래밍

        ```
        - 자바에는 함수의 개념이 없다.

        자바의 메소드는 일급 함수가 아니므로, 다른 메소드로 전달할 수 없다. 자바에는 모든 것이 객체다. 메소드는 객체의 행위를 정의하고 객체의 상태를 변경한다.) 이런 이유로 기존의 자바 언어 체계에서는 함수형 언어를 언어 차원에서 지원하지는 못하였다.
        (함수형 프로그래밍의 조건을 만족하도록 구현한다면 기존에도 가능하다고 할 수 있겠다.)

        - Java8 에서 함수형 인터페이스(단 하나의 메소드만이 선언된 인터페이스)라는 개념을 도입

        - 함수형 인터페이스의 경우, 람다식으로 표현이 가능할 수 있게 제공

        - Java8에서 함수형 인터페이스라는 개념과 람다식 표현을 통해 입력에 의해서만 출력이 결정되도록 ‘순수한 함수’를 표현할 수 있게 됨

        - 람다식으로 표현함으로써 ‘익명 함수’를 정의할 수 있게 됨,

        - 함수형 인터페이스의 메소드에서 또다른 함수형 인터페이스를 인자로 받을 수 있도록 하여 ‘고계 함수’를 정의할 수 있게 됨

        - 즉, 함수형 프로그래밍 언어의 조건을 만족시킬 수 있게 되었다고 할 수 있다.

        ```


        - 함수형 Interface

            ```java

            public interface Functional1 {
              boolean accept();
            }

            public interface Functional2 {
              boolean accept();
              default boolean reject() { return !accept(); }
            }

            @FunctionalInterface
            public interface Functional3 {
              boolean accept();
            }

            public interface NotFunctional {
              boolean accept();
              boolean reject();
            }

            ```

            - http://multifrontgarden.tistory.com/125?category=471239

        - 상태가 없는 객체 (Stateless Object)

            ``` java

            @FunctionalInterface
            interface Movable{
                void move(String str);
            }


            Movable movable = new Movable() {
                private int speed;

                @Override
                public void move() {
                    System.out.println("gogo move move current speed : " + speed);
                }
            };

            ```

            - 함수란 인풋(Input)에 의해서만 아웃풋(Output)이 달라져야한다.

            - 메서드는 객체에 종속적이기때문에 인풋이 달라지지않아도 객체의 상태에 따라 결과값이 다를 수 있다.

            - 함수형 프로그래밍에서 함수는 인풋에 의해서만 아웃풋이 달라져야한다.

            - 그것을 지원하기위해 람다 표현식으로 구현할때 객체는 상태를 가질 수 없다.


        - 행위 파라미터화 (Behavior Parameterize)

            - 보통 코드를 짤때 데이터를 매개변수로 전달하고 해당 데이터를 가지고 무언가 행위를 하는 메서드를 구현하기 마련이다.

            - 하지만 데이터를 전달하는 것이 아닌 행위를 전달하게되면 좀 더 유연한 코드가 될 수 있다

            ``` java

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

            ```

### 1.1.2 리액티브 프로그래밍 개념 잡기

- 리액티브 프로그램은 주변의 환경과 끊임없는 상호작용을 하는데 프로그램이 주도하는 것이 아니라 환경이 변하면 이벤트를 받아 동작한다

- 리액티브 프로그램은 외부 요구에 반응에 맞춰 일하고 대부분 정확한 인터럽트 처리를 담당한다.

- rxJava

    - .NET 환경의 Reactive Extentions 를 JVM 위의 자바언어로 구현해 놓은 라이브러리

### 1.2 RXJava를 만들게 된 이유

- 동시성을 적극적으로 끌어안을 필요가 있다. (Embrace Concurrency)

    - 자바 언어가 동시성을 처리하는데 번거로움이 있다

    - 클라이언트의 요청을 처리할 때 다수의 비동기 실행 흐름을 생성하고 그것의 결과를 취합하여 최종 리턴하는 방식

- 자바 Future를 조합하기 어렵다는 점을 해결해야 한다. (Java Futures are Expensive to Compose)

    - 비동기 흐름을 조합할 방법이 거의 없었다 (Java 8의 CompletableFutre 가 없었던 시절)

    - RxJava 에서는 비동기 흐름을 조합 할 수 있는 방법을 제공

    - RxJava 에서는 조합하는 실행 단위를 리액티브 연산자라고 한다.

- 콜백 방식의 문제점을 개선해야 한다. (Callbacks Have Their Own Problems)

    - 콜백 지옥 상황이 코드의 가독성을 떨어 뜨리고 문제 발생 시 디버깅을 어렵게 한다

    - RxJava는 콜백을 사용하지 않는 방향으로 설계해 이를 해결한다


- RxJava 2는 Reactive-Streams 으로 새롭게 개선


### 1.3 RxJava 처음 시작하기


```gradle

group 'guppy'
version '1.0-SNAPSHOT'

apply plugin: 'java'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'

    // https://mvnrepository.com/artifact/com.google.guava/guava
    compile group: 'com.google.guava', name: 'guava', version: '24.0-jre'

    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    compile group: 'org.slf4j', name: 'slf4j-api', version: '1.7.25'

    // https://mvnrepository.com/artifact/io.reactivex.rxjava2/rxjava
    compile group: 'io.reactivex.rxjava2', name: 'rxjava', version: '2.1.9'

}


```

```java

public class FirstExample {

    public void emit () {
        // Observable 클래스
        // : 데이터의 변화가 발생하는 데이터 소스
        // : 시작점 (?)

        // just() 함수
        // : 가장 단순한 Observable 선언 방식
        // : "Hello"와 "RxJava2!!"를 발행

        // subscribe() 함수
        // : Observable을 구독한다
        // subscribe() 함수를 호출해야 비로소 변화한 데이터를 구독자에게 발행한다.
        Observable.just("Hello", "RxJava 2!!")
                .subscribe(data -> System.out.println(data));
                //.subscribe(System.out::println);
    }

    public static void main (String args[]) {
        FirstExample demo = new FirstExample();
        demo.emit();
    }
}


```

### 1.4 RxJava를 어떻게 공부할 것인다

- 자바는 전통적이 스레드 기반의 프로그래밍이다.

- RxJava는 비동기 프로그래밍을 위한 라이브러리라서 개념과 접근 방식이 다르다

- 전통적인 스레드 기반의 프로그래밍은 다수의 스레드를 활용하기 어렵다.

- RxJava는 함수형 프로그래밍 기법을 도입

    - 함수형 프로그래밍은 부수 효과가 없는 순수함수를 지향하므로 스레드에 안전하다

- 권장 학습 순서

    - Observable 클래스를 명확하게 이해한다. 특히 뜨거운 차가운 옵져버블의 개념을 꼭 이해해야한다.

    - 간단한 예제로 map(), filter(), reduce(), flatMap() 함수의 사용법을 익힌다.

    - 생성 연산자, 결합 연산자, 변환 연산자 등 카테고리별 주요 함수를 공부한다.

    - 스케줄러의 의미를 배우고 subscribeOn()과 observeOn() 함수의 차이를 알아둔다.

    - 그 밖의 디버깅 흐름 제어 함수를 익힌다.


### 1.5 마블 다이어 그램 보는법

- http://reactivex.io/documentation/observable.html

- http://reactivex.io/documentation/operators/combinelatest.html
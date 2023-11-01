package com.devyu.effectivejava.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * [5장] - 제네릭
 * [아이템 28] - 배열보다는 리스트를 사용하라
 *
 * [요약] -공변성을 가진 배열은 런타임 에러를 발생시킬 위험이 있으므로 불공변성을 가진 리스트 사용하자
 * A 타입이 B 타입의 서브 타입일 때, A 배열은 B 배열의 서브 타입이 될 수 있으면 공변이고 A 리스트는 B 리스트의 서브 타입이 될 수 없으면 불공변이다.
 * 배열은 런타임에 원소의 타입을 동적으로 인지하여 런타임 에러를 발생시킬 수 있고 제네릭은 타입 소거로 인하여 실체화 될 수 없으므로 컴파일 에러가 발생한다. 컴파일 에러 좋아요~
 */
public class Main {

    static class GrandFather {}
    static class Father extends GrandFather {}
    static class Me extends Father {}

    public static void main(String[] args) {

        /**
         * 공변
         *
         * 코드를 보면 `GrandFather` 클래스를 상속한 서브 타입 `Father` 클래스는 배열의 **공변성**으로 인하여
         * `Father[]` 배열도 `GrandFather[]` 배열의 서브 타입으로 인정되어 다형성을 통한 참조가 가능한 것이다.
         */
        GrandFather[] grandFathers = new Father[1];

        Object[] objectArray = new List[1];
        objectArray[0] = "str"; // 런타임에 ArrayStoreException 발생...ㅠ

        /**
         * 불공변
         *
         * A 타입이 B 타입의 서브 타입일 때, A 배열은 B 배열의 서브 타입이 될 수 있으면 공변이고
         * A 리스트는 B 리스트의 서브 타입이 될 수 없으면 불공변이다.
         */
//        ArrayList<GrandFather> fathers = new ArrayList<Father>(); // 컴파일 에러...!!
//        List<Object> ol = new ArrayList<Long>();
//        ol.add("str"); // 컴파일 에러...!

        Chooser numChooser = new Chooser(new Object[]{1, 2, 3});
        int ch1 = (int) numChooser.choose();
        System.out.println(ch1);

        Chooser strChooser = new Chooser(new String[]{"가", "나", "다"});
        String ch2 = (String) strChooser.choose();
        System.out.println(ch2);

//        Chooser numChooser2 = new Chooser2(new Object[]{1, 2, 3});
//        numChooser2.choose();
//        System.out.println(ch1);

//        Chooser strChooser2 = new Chooser2(new String[]{"가", "나", "다"});
//        String ch2 = (String) strChooser2.choose();
//        System.out.println(ch2);

    }

    static class Chooser {

        private final Object[] choiceArray;

        Chooser(Object[] choiceArray) {
            this.choiceArray = choiceArray;
        }

        public Object choose() {
            ThreadLocalRandom current = ThreadLocalRandom.current();
            return choiceArray[current.nextInt(choiceArray.length)];
        }

    }

    static class Chooser2<T> {

        private final T[] choiceArray;

        Chooser2(Collection<T> choices) {
            this.choiceArray = (T[]) choices.toArray(); // 경고...!
        }

        public T choose() {
            ThreadLocalRandom current = ThreadLocalRandom.current();
            return choiceArray[current.nextInt(choiceArray.length)];
        }

    }

    static class Chooser3<T> {

        private final List<T> choiceList;

        Chooser3(Collection<T> choices) {
            this.choiceList = new ArrayList<>(choices);
        }

        public T choose() {
            ThreadLocalRandom current = ThreadLocalRandom.current();
            return choiceList.get(current.nextInt(choiceList.size()));
        }

    }

}

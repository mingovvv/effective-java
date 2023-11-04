package com.devyu.effectivejava.item31;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

    static class Box<T> {

        private List<T> list = new ArrayList<>();

        public void add(List<T> objs) {
            for (T t : objs) {
                list.add(t);
            }
        }

        public void add2(List<? extends T> objs) {
            for (T t : objs) {
                list.add(t);
            }
        }

        public void pop(List<T> objs) {
            for (T t : list) {
                objs.add(t);
            }
        }

        public void pop2(List<? super T> objs) {
            for (T t : list) {
                objs.add(t);
            }
        }

    }

    public static void main(String[] args) {

        Box<Number> box = new Box<>();
//        List<Integer> integers = List.of(1, 2, 3, 4, 5);
////        box.add(integers); // 컴파일 에러...!
//        box.add2(integers);

        List<Object> empty = List.of();
//        box.pop(empty);
        box.pop2(empty);


        // 상한경계 와일드카드
        Boxx<? extends Fruit> box1 = new Boxx<Fruit>();
        Boxx<? extends Fruit> box2 = new Boxx<Apple>();
        Boxx<? extends Fruit> box3 = new Boxx<Banana>();

        // 하한경계 와일드카드
        Boxx<? super Fruit> box4 = new Boxx<Fruit>();
        Boxx<? super Fruit> box5 = new Boxx<Food>();
        Boxx<? super Fruit> box6 = new Boxx<Object>();
    }

    static class Boxx<T> {
    }

    static class Food {
    }

    static class Fruit extends Food {
    }

    static class Vegetable extends Food {
    }

    static class Apple extends Fruit {
    }

    static class Banana extends Fruit {
    }

    static class Carrot extends Vegetable {
    }

}

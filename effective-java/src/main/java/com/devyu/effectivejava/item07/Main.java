package com.devyu.effectivejava.item07;

public class Main {

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("가");
        s.push("나");
        s.push("다");
        s.push("라");
        s.push("마");
        s.push("바");
        s.push("사");

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

}

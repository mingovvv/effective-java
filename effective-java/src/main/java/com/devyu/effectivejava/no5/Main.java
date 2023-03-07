package com.devyu.effectivejava.no5;

public class Main {

    public static void main(String[] args) {

        // 의존 객체 주입 패턴을 사용해 유연한 인스턴스를 생성
        // '불변'을 보장하여 여러 클라이언트가 의존 객체들을 공유할 수 있음
        SpellChecker aDictionary = new SpellChecker("A사전");
        SpellChecker bDictionary = new SpellChecker("B사전");

    }

}

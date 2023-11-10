package com.devyu.effectivejava.item44;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * [7장] - 람다와 스트림
 * [아이템 44] - 표준 함수형 인터페이스를 사용하라
 *
 * [요약] - 함수형 인터페이스는 람다를 통해 간결하고 가독성을 확보하였다. API 설계 시, 람다를 염두하고 설계해보도록 하자.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 람다 등장과 함께 상위 클래스의 기본 메서드를 재정의해 원하는 동작을 구현하는 패턴은 매력이 떨어졌다.
         *
         * 함수 객체를 매개변수로 받는 생성자와 메서드를 만들어서 대체한다.
         */
        Map<String, String> m = new SubLinkedHashMap<>();

        m.put("a", "a");
        m.put("b", "b");
        m.put("c", "c");
        m.put("d", "d");
        m.put("e", "e");

        System.out.println(m);

        /**
         * 함수형 인터페이스
         *  - 박싱된 기본 타입을 넣어서 사용하지 말자
         *  - 자주 쓰이고 이름으로 명확한 용도를 설명하고 유용한 디폴트 메서드를 제공한다면 전용 함수형 인터페이스를 구현하자
         *  - 함수형 인터페이스를 구현 했다면 @FunctionalInterface 애너테이션을 달고 개발자의 의도를 다른 개발자 및 컴파일러에게 전하자
         */

        SubLinkedHashMap<String, String> tt = new SubLinkedHashMap<>();

    }

    static class SubLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            EldestEntryRemovalFunction<K, V> removalFunction = (map, dd) -> map.size() > 3;
            return removalFunction.remove(this, eldest);
        }
    }

    /**
     * 굳이 사용할 필요가 없다.
     * 자바 표준 라이브러리에 이미 같은 모양의 인터페이스가 있다. java.util.function 패키지
     * 필요한 용도에 맞는게 있다면 굳이 구현하지 말고 표준 함수형 인터페이스를 활용하라
     */
    @FunctionalInterface
    interface EldestEntryRemovalFunction<K, V> {
        boolean remove(Map<K, V> map, Map.Entry<K, V> eldest);
    }


}

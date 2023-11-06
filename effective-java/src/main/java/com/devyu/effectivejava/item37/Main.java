package com.devyu.effectivejava.item37;

import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [6장] - 열거 타입과 애너테이션
 * [아이템 37] - ordinal 인덱싱 대신 EnumMap을 사용하라
 *
 * [요약] - oridinal 쓰지마라
 */
public class Main {

    public static void main(String[] args) {

        List<Favorite> source = List.of(
                new Favorite("AAA", Favorite.Color.RED),
                new Favorite("BBB", Favorite.Color.GREEN),
                new Favorite("AAA", Favorite.Color.YELLOW),
                new Favorite("BBB", Favorite.Color.YELLOW)
        );

        /**
         * [배열을 사용해서 리스트 담는 방법]
         *  - Enum의 ordinal 메서드를 배열의 인덱스로 사용함
         *  - 동작은 하나 제니릭과 배열은 호환성이 좋지 않아 '비검사 형변환'을 수행해야 함
         *  - 배열은 각 인덱스의 의미를 알지 못하니 출력할 때, 직접 레이블을 달아줘야 함
         *  - 정수는 열거 타입과 달리 안전하지 않음
         */
        List<Favorite>[] array = (List<Favorite>[]) new List[Favorite.Color.values().length]; // '비검사 형변환'

        Arrays.setAll(array, s -> new ArrayList<>()); // ArrayList 초기화

        for (Favorite favorite : source) {
            array[favorite.color.ordinal()].add(favorite);
        }

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);

        /**
         * [EnumMap을 사용해서 리스트 담는 방법]
         *  - 열거 타입을 키로 사용하고 상수를 값으로 매핑
         *  - 코드가 더 명확해지고 안전하지 않은 형변환이 사용되지 않음
         *  - 출력 결과에 레이블을 달 필요가 없음
         *  - 배열 인덱스를 계산하는 과정에서 오류가 날 가능성도 없음
         *
         *  [장점]
         *   - EnumMap 의 경우, 내부적으로 배열을 사용해서 값을 저장하여 해싱이 필요 없다.
         *   - EnumMap은 전달된 Enum 타입의 상수 개수만큼 저장 공간을 미리 확보하므로 리사이징이 필요 없다. (실제 테스트 결과 2배 ~ 3배 차이를 보임)
         *   - EnumMap은 Enum의 상수가 선언된 순서대로 정렬되어 있다.
         *
         */
        EnumMap<Favorite.Color, List<Favorite>> enumMap = new EnumMap<>(Favorite.Color.class);

        for (Favorite.Color value : Favorite.Color.values()) {
            enumMap.put(value, new ArrayList<>()); // ArrayList 초기화
        }

        for (Favorite favorite : source) {
            enumMap.get(favorite.color).add(favorite);
        }

        System.out.println(enumMap.get(Favorite.Color.RED));
        System.out.println(enumMap.get(Favorite.Color.YELLOW));
        System.out.println(enumMap.get(Favorite.Color.GREEN));

        /**
         * [stream()을 사용해서 리스트 담는 방법 - 1]
         *  - 고유한 맵 구현체를 사용했기 때문에 EnumMap을 써서 얻은 공간과 성능의 [장점]이 사라진다...!!
         */
        Map<Favorite.Color, List<Favorite>> streamMap = source.stream().collect(Collectors.groupingBy(s -> s.color));
        System.out.println(streamMap.get(Favorite.Color.RED));
        System.out.println(streamMap.get(Favorite.Color.YELLOW));
        System.out.println(streamMap.get(Favorite.Color.GREEN));

        /**
         * [stream()을 사용해서 리스트 담는 방법 - 2]
         *  - EnumMap enumMap 구현체를 지정하여 초기화
         */
        Map<Favorite.Color, List<Favorite>> streamMap2 = source.stream().collect(Collectors.groupingBy(
                                                                        s -> s.color
                                                                        , () -> new EnumMap<>(Favorite.Color.class)
                                                                        , Collectors.toList()
                                                                    ));

    }

    record Favorite(String name, Main.Favorite.Color color) {

            enum Color {
                RED, YELLOW, GREEN
            }

    }

}

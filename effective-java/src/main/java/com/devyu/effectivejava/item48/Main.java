package com.devyu.effectivejava.item48;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * [7장] - 람다와 스트림
 * [아이템 48] - 스트림 병렬화는 주의해서 적용하라
 *
 * [요약] - 계산이 올바르게 수행되고, 성능이 확실하게 빨라질 거라는 확신이 없다면 스트림은 병렬화하지 마라
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        /**
         * 데이터 소스가 Stream.iterate거나 연산으로 limit를 쓰면 파이프라인 병렬화로는 성능 개선을 기대할 수 없음
         *  - 스트림 라이브러리가 파이프라인을 병렬화하는 방법을 찾아내지 못했기 때문
         *
         * 데이터 소스가 ArrayList, HashMap, HashSet, ConcurrentHashMap 의 인터페이스 거나 배열, int 범위, long 범위 일 때 병렬화 효과가 가장 좋음
         *  - 이러한 자료구조들은 데이터를 원하는 크기로 정확하게 나눌수 있어서 다수의 스레드에 분배하기 좋다는 특징을 지님
         */

        // 메르센 소수 구하기
        primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);

    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }

}

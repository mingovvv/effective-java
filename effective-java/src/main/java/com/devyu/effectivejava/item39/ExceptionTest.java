package com.devyu.effectivejava.item39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 메타 애너테이션 : @Retention, @Target
 *  - @Retention : 런타임에도 유지 되어야 함
 *  - @Target : 메서드 선언에서만 사용되어야 함
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {

    /**
     * 명시한 예외를 던져야만 성공하는 테스트 메서드용 애너테이션
     *  - 한정적 와일드 카드 사용(한정적 타입 토큰)
     *  - Throwable을 확장한 클래스의 Class 객체
     *  - 모든 예외 타입을 다 수용
     */
    Class<? extends Throwable> value();

}

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
public @interface Test {


}

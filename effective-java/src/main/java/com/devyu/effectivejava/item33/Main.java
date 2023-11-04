package com.devyu.effectivejava.item33;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * [5장] - 제네릭
 * [아이템 33] - 타입 안전 이종 컨테이너를 고려하라
 *
 * [요약] -
 */
public class Main {

    public static void main(String[] args) {

        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "mingo");
        favorites.putFavorite(Integer.class, 9999);
        favorites.putFavorite(Class.class, Favorites.class);

        String favoriteString = favorites.getFavorite(String.class);
        Integer favoriteInteger = favorites.getFavorite(Integer.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);

        System.out.println(favoriteString);
        System.out.println(favoriteInteger);
        System.out.println(favoriteClass.getName());

    }

    /**
     * 타입 안전 이종 컨테이너 패턴
     */
    static class Favorites {

        private Map<Class<?>, Object> favorites = new HashMap<>();

        public <T> void putFavorite(Class<T> type, T instance) {
            favorites.put(Objects.requireNonNull(type), instance);
        }

        public <T> T getFavorite(Class<T> type) {
            return type.cast(favorites.get(type));
        }

    }
}

package com.devyu.effectivejava.no9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "";

        BufferedReader br = null;

        /**
         * try-finally 자원회수 방법
         *   - try 블록과 finally 블록 모두 예외가 발생할 경우가 있음
         *   두번째 finally 블록이 첫 번째 예외를 삼켜 추적하기 용이하지 않음
         */
        try {
            br = new BufferedReader(new FileReader(path));

            String s = br.readLine();
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 자원회수 이게 맞을까..?
            br.close();
        }

        /**
         * try-with-resources 자원회수 방법
         *   - 자원회수 객체가 AutoCloseable 인스터페이슷 구현해야 함
         *   - catch 블록을 조합하여 유연하게 대처 가능
         */
        try (BufferedReader br2 = new BufferedReader(new FileReader(path))) {
            String s2 = br2.readLine();
            System.out.println(s2);
        } catch (Exception e) {
            // ~~
        }

    }

}

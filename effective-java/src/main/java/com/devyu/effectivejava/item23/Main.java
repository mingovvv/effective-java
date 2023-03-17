package com.devyu.effectivejava.item23;

import com.devyu.effectivejava.item23.abstr.Circle;
import com.devyu.effectivejava.item23.abstr.Rectangle;
import com.devyu.effectivejava.item23.abstr.Square;

public class Main {

    public static void main(String[] args) {

        /**
         * 문제가 많은 'Figure' 클래스
         *
         *   - 한 클래스 내부에서 여러 도형을 인스턴스화 시키기 위해 쓸데없는 코드가 들어가게 됨
         *   - 가독성이 나쁘고 사용하지 않는 필드가 늘어남
         *   - 쓰이지 않는 필드까지 생성자 초기화가 필요함
         *   - '인스턴스 타입만으로 현재 나타내는 의미를 알 수가 없음'
         */
        Figure rectangle = new Figure(5, 10);
        Figure circle = new Figure(100);

        /**
         *   - 타입을 확실히 알 수 있음
         *   - 특정 의미만 매개변수로 받을 수 있음
         *   - 불필요한 필드 또는 생성자를 코드화 시키지 않음
         *   - 유연함
         *
         */
        Rectangle rectangle1 = new Rectangle(5, 10);
        Circle circle1 = new Circle(100);

        // 유연함
        Square square = new Square(5, 10);

    }

}

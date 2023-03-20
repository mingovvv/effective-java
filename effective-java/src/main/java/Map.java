import java.util.HashMap;

public class Map {

    public static void main(String[] args) {

        /**
         * putIfAbsent(key, value)
         *
         *  - key가 존재할 경우
         *      save : x
         *      return : old value
         *  - key가 존재하지 않을 경우
         *      save : new value
         *      return : null
         *
         */
        System.out.println();
        System.out.println("** putIfAbsent **");

        HashMap<String, String> m1 = new HashMap<>();
        m1.put("key1", "value1");
        m1.putIfAbsent("key1", "value1-1");
        m1.putIfAbsent("key2", "value2");

        System.out.println(m1);

        /**
         * compute(key, (key, old value) -> T)
         *
         *  - key가 존재할 경우
         *      save : 연산값
         *      return : 연산값
         *  - key가 존재할 경우 && 연산값이 null
         *      save : x
         *      remove : o
         *      return : null
         *  - key가 존재하지 않을 경우,
         *      save : 연산값
         *      return : 연산값
         *
         */
        System.out.println();
        System.out.println("** compute **");

        HashMap<String, String> m2 = new HashMap<>();
        m2.put("key1", "value1");
        m2.compute("key1", (k, v) -> {
            return k + " " + v;
        });
        m2.compute("key2", (k, v) -> {
            return k + " " + v;
        });
        m2.compute("key1", (k, v) -> {
            System.out.println("연산값이 null이라 존재하던 key는 삭제됩니다.");
            return null;
        });

        System.out.println(m2);

        /**
         * computeIfAbsent(key, key -> T)
         *
         *  - key가 존재할 경우
         *      save : x
         *      return : old value
         *  - key가 존재하지 않을 경우,
         *      save : 연산값
         *      return : 연산값
         *
         */
        System.out.println();
        System.out.println("** computeIfAbsent **");

        HashMap<String, String> m3 = new HashMap<>();
        m3.put("key1", "value1");
        m3.computeIfAbsent("key1", k -> {
            System.out.println("key가 존재하는 경우 old value를 반환합니다.");
            return k;
        });
        m3.computeIfAbsent("key2", k -> {
            System.out.println("연산값을 반환합니다.");
            return k;
        });
        System.out.println(m3);

        /**
         * computeIfPresent(key, (key, old value) -> T)
         *
         *  - key가 존재할 경우, 연산값 != null
         *      save : 연산값
         *      return : 연산값
         *  - key가 존재할 경우, 연산값 == null
         *      save : x
         *      remove key : o
         *      return : null
         *  - key가 존재하지 않을 경우,
         *      return : null
         *
         */
        System.out.println();
        System.out.println("** computeIfPresent **");

        HashMap<String, String> m4 = new HashMap<>();

        m4.put("key1", "value1");
        String key1 = m4.computeIfPresent("key1", (k, v) -> {
            System.out.println("old key와 old value를 인자로 받습니다. 반환값은 람다 연산값입니다.");
            return k + " " + v;
        });

        m4.put("key3", "value3");
        String key3 = m4.computeIfPresent("key3", (k, v) -> {
            System.out.println("key는 존재하지만 람다식 연산값이 null이라서 해당키는 삭제됩니다.");
            return null;
        });

        String key2 = m4.computeIfPresent("key2", (k, v) -> {
            System.out.println("old key와 old value를 인자로 받습니다. 반환값은 람다 연산값입니다.");
            return "key가 존재하지 않아서 null을 반환하고 끝납니다.";
        });

        System.out.println(m4);

    }

}

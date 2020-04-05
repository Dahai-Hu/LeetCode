package source.hashmap;

import java.util.HashMap;

/**
 * @hurusea
 * @create2020-04-05 11:16
 */
public class Test {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("no1", "hello");
        map.put("no2", 0.1);
        System.out.println(map.get("no2"));
    }
}

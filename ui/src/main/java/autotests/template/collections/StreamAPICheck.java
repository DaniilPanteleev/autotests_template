package autotests.template.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPICheck {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {
            {

                add("456");
                add("789");
                add("000");
            }

        };

        List<Integer> list2 = list.stream().map(a -> Integer.parseInt(a)).collect(Collectors.toList());

        Map<Integer, String> map = new HashMap<>() {
            {
                put(1, "one");
                put(2, "two");
                put(3, "three");
            }
        };
        map.keySet().stream().map(a -> a + " - " + map.get(a)).collect(Collectors.toList()).forEach(a -> System.out.println(a));
        List test = Stream.of("sdf" , "aer" ,"asd").filter(a -> a.contains("a")).collect(Collectors.toList());
        System.out.println(test);


    }
}

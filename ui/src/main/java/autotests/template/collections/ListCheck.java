package autotests.template.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ListCheck {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123", "456", "567");
//        list.forEach(a -> System.out.println(a));
        HashSet<String> set = new HashSet<>(list);
//        set.forEach(a -> System.out.println(a));
        HashMap<Triangle, String > map = new HashMap<>(){
            {
               put(new Triangle(1,1), "1");
               put(new Triangle(2,2), "2");

            }
        };
        //Map<Triangle, String > map2 = Map.of(new Triangle(1,1), "1",new Triangle(2,2),"2");
//        Map<Triangle, String > map2 = Map.of(new Triangle(1,1), "1",new Triangle(2,2),"2");
        map.forEach((k, v) -> System.out.println(k + " " + v ));



    }
}

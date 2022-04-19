package autotests.template.seven;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestWithHelp {
    public static void main(String[] args) {
        Integer[] x = new Integer[] {1, 2, 3, 4, 5, 3, 3, 8};
        Map<Integer, Integer> map = new TestWithHelp().arrayToMap(x);
        System.out.println(map);

    }
    public <K> Map<K, Integer> arrayToMap(K[] ks){
        return Stream.of(ks).collect(Collectors.toMap(k -> k, v -> 1, (s, s1) -> {
            int i = 0;
            return s + s1;
        }));

    };
}

package autotests.template.seven;

import java.util.Collection;
import java.util.stream.Collectors;

public class Duplicates {

    public static <T> Collection<T> delDuplicates(Collection<T> collection){
        return  collection.stream().distinct().collect(Collectors.toList());
    }

}

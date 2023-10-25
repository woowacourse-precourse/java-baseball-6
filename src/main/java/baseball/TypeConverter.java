package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {

    //String -> List<Integer> (ex: "123" -> {1,2,3})
    public static List<Integer> stringToIntegerList(String string) {
        return Arrays.stream(string.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}

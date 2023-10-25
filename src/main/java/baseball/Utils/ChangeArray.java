package baseball.Utils;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ChangeArray {
    public static List<Integer> stringToList(String Inputstring){
        return Arrays.stream(Inputstring.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

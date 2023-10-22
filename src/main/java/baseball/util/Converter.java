package baseball.util;

import baseball.Baseball;
import java.util.Arrays;

public class Converter {


    public static void toIntegerList(String str) {
        Baseball.userNum = Arrays.stream(str.trim().split(""))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }
}

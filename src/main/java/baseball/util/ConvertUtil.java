package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class ConvertUtil {

    public static List<Integer> convertStrToIntList(String input) {
        List<Integer> list = new ArrayList<>();
        for (char character : input.toCharArray()) {
            list.add(character - '0');
        }
        return list;
    }
    
}

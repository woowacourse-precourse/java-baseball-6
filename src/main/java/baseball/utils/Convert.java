package baseball.utils;

import baseball.model.NumberList;
import java.util.ArrayList;
import java.util.List;

public class Convert {
    public static NumberList stringToNumberList(String numberString) {
        List<Integer> numberList = new ArrayList<>() {{
            for (int i = 0; i < numberString.length(); i++) {
                int number = numberString.charAt(i) - '0';
                add(number);
            }
        }};
        return new NumberList(numberList);
    }
}

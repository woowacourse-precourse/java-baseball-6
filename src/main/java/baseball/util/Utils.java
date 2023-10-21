package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> stringToList(String number) {
        return number.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public static int stringToInt(String number) {
        validateEndNumber(Integer.parseInt(number));

        return Integer.parseInt(number);
    }

    public static void validateEndNumber(int number) {
        if(number < 1 || number > 2) {
            throw new IllegalArgumentException("1, 2 만 입력 가능합니다");
        }
    }
}

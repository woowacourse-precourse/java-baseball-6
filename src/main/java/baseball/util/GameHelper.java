package baseball.util;

import java.util.List;

public class GameHelper {

    private GameHelper() {
    }

    public static List<Integer> numberToIntegerList(String number) {
        return number.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }
}

package baseball.util;

import static baseball.model.message.ErrorMessage.DO_NOT_CALL_THIS_CODE;

import java.util.List;

public class GameHelper {

    private GameHelper() {
        throw new AssertionError(DO_NOT_CALL_THIS_CODE.getMessage());
    }

    public static List<Integer> changeNumberToIntegerList(String number) {
        return number.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }
}

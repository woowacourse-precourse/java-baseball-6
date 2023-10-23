package baseball;

import baseball.model.GameNumber;
import baseball.view.Message;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {

    public static void verifyException(List<Integer> input){
        duplicate_Num(input);
        invalidInput(input);
    }

    public static void duplicate_Num(List<Integer> input) {
        Set<Integer> set = new HashSet<>();

        for (Integer item : input) {
            if (!set.add(item)) {
                throw new IllegalStateException(Message.DUPLICATE_NUM);
            }
        }
    }

    public static void invalidGame() {
        throw new IllegalStateException(Message.INVALID_GAME_NUMBER);
    }

    public static void invalidInput(List<Integer> input) {
        if (input.size() != GameNumber.NUMBER_LENGTH) {
            throw new IllegalArgumentException(Message.INVALID_INPUT_MESSAGE);
        }
    }
}

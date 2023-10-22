package baseball;

import baseball.model.GameNumber;
import baseball.view.Message;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {

    public static void duplicate_Num(List<Integer> li) {
        Set<Integer> set = new HashSet<>();

        for (Integer item : li) {
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

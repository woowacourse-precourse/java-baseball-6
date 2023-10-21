package baseball.validate;

import java.util.List;

public class GameValidate {
    public void checkGameRestartInput(Integer number) {
        if (number == 1 ) {
           return;
        }
        if (number == 2 ) {
            return;
        }
        throw new RuntimeException();
    }

    public void checkPlayerGuessNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0 || number > 10) {
                throw new RuntimeException();
            }
        }
    }
}

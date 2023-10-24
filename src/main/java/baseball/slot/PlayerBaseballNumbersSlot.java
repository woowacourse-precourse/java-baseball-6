package baseball.slot;

import baseball.NumbersInputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayerBaseballNumbersSlot extends BaseballNumbersSlot {
    @Override
    public void updateNumbers() {
        String playerInput = Console.readLine();
        List<Integer> playerNumbers = new ArrayList<>();
        for (int index = 0; index < playerInput.length(); index++) {
            int number = playerInput.charAt(index) - '0';
            playerNumbers.add(number);
        }
        if (!NumbersInputValidator.validatePlayerNumbers(playerNumbers)) {
            throw new IllegalArgumentException();
        }
        this.numbers = playerNumbers;
    }
}

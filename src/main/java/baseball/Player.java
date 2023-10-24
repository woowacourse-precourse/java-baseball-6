package baseball;

import camp.nextstep.edu.missionutils.Console;
import static baseball.constants.Constant.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    public List<Integer> setPlayerNumber() throws IllegalArgumentException {
        String playerInput = Console.readLine();
        return playerInputToInteger(playerInput);
    }

    public List<Integer> playerInputToInteger(String playerInput) throws IllegalArgumentException {
        String[] split = playerInput.split("");
        if (split.length != NUMBER_SIZE) {
            throw new IllegalArgumentException(MAXIMUM_NUMBER_3_EXCEPTION);
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            numbers.add(Integer.parseInt(split[i]));
        }

        checkDuplicatedNumber(numbers);
        return numbers;
    }

    public void checkDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> notDuple = new HashSet<>();
        for (int num : numbers) {
            if (notDuple.contains(num)) {
                throw new IllegalArgumentException(DUPLICATED_EXCEPTION);
            }
            notDuple.add(num);
        }
    }

    public boolean restart() {
        String num = Console.readLine();
        return numToBoolean(num);
    }

    public boolean numToBoolean(String num) {
        int number = Integer.parseInt(num);
        if (number == 1) return true;
        if (number == 2) return false;
        throw new IllegalArgumentException(WRONG_INPUT_EXCEPTION);
    }

}

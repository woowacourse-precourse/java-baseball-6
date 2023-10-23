package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int NUMBER_LENGTH = 3;
    private static final int BALL = 0;
    private static final int STRIKE = 1;

    private final List<Integer> playerNumber = new ArrayList<>();
    private final Validator validator = new Validator();

    public void inputPlayerNumber() {
        playerNumber.clear();

        String input = Console.readLine();
        validator.validateInput(input);

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            playerNumber.add(Character.getNumericValue(input.charAt(i)));
        }
    }

    public int[] checkStrikeAndBall(List<Integer> computerNumber) {
        int[] result = new int[2];
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.contains(playerNumber.get(i))) {
                result[BALL]++;
            }
        }
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.get(i) == playerNumber.get(i)) {
                result[BALL]--;
                result[STRIKE]++;
            }
        }
        return result;
    }
}


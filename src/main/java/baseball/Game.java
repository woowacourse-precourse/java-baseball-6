package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private static final int NUMBER_SIZE = 3;

    private List<Integer> target;

    public Game() {
        setNewTarget();
    }

    public void setNewGame() {
        setNewTarget();
    }

     private void setNewTarget() {
        target = new ArrayList<>();
        while (target.size() < NUMBER_SIZE) {
            int r = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(r)) target.add(r);
        }
    }

    /**
     * @param input The user's input
     * @return An array of two elements:
     * the first element represents the number of strikes,
     * and the seconds element represents the number of balls.
     * @throws IllegalArgumentException If the input doesn't meet the condition of the target.
     */
    public List<Integer> playRound(String input) throws IllegalArgumentException {
        List<Integer> userInput = parseUserInput(input);
        return compareUserInput(userInput);
    }

    private List<Integer> parseUserInput(String input) throws IllegalArgumentException {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("User didn't give 3 digits");
        }
        Integer[] userInput = new Integer[NUMBER_SIZE];
        for (int i = 0; i < NUMBER_SIZE; i++) {
            userInput[i] = input.charAt(i) - '0';
            if (userInput[i] < 1 || userInput[i] > 9) throw new IllegalArgumentException("User's input include character which is not included in 1 to 9");
            for (int j = 0; j < i; j++) {
                if (userInput[i] == userInput[j]) throw new IllegalArgumentException("There are duplicate digits in the user input");
            }
        }
        return Arrays.asList(userInput);
    }

    private List<Integer> compareUserInput(List<Integer> userInput) {
        Integer[] result = new Integer[]{0, 0};
        for (int i = 0; i < NUMBER_SIZE; i++) {
            for (int j = 0; j < NUMBER_SIZE; j++) {
                if (target.get(i) != userInput.get(j)) continue;
                if (i == j) result[0]++;
                else result[1]++;
            }
        }
        return Arrays.asList(result);
    }

    public boolean isWin(List<Integer> result) {
        return result.get(0) == NUMBER_SIZE;
    }

    public int getNumberSize() {
        return NUMBER_SIZE;
    }
}

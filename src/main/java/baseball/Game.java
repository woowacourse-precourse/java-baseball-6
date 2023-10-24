package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    // Change in the implementation guide
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
     *
     * @param input The user's input
     * @return An array of two elements:
     * the first element represents the number of strikes,
     * and the seconds element represents the number of balls.
     * @throws IllegalArgumentException If the input doesn't meet the condition of the target.
     */
    public int[] playRound(String input) throws IllegalArgumentException {
        int[] userInput = parseUserInput(input);
        return compareUserInput(userInput);
    }

    // Change in the implementation guide.
    private int[] parseUserInput(String input) throws IllegalArgumentException {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("Invalid input for game.");
        }
        int[] userInput = new int[NUMBER_SIZE];
        for (int i = 0; i < NUMBER_SIZE; i++) {
            userInput[i] = input.charAt(i) - '0';
            if (userInput[i] < 1 || userInput[i] > 9) throw new IllegalArgumentException("Invalid input for game");
            for (int j = 0; j < i; j++) {
                if (userInput[i] == userInput[j]) throw new IllegalArgumentException("Invalid input for game");
            }
        }
        return userInput;
    }

    // TODO: refactor
    //
    // Change in the implementation guide
    private int[] compareUserInput(int[] userInput) {
        int[] ret = new int[]{0, 0};
        for (int i = 0; i < NUMBER_SIZE; i++) {
            for (int j = 0; j < NUMBER_SIZE; j++) {
                if (target.get(i) != userInput[j]) continue;
                if (i == j) ret[0]++;
                else ret[1]++;
            }
        }
        return ret;
    }

    public boolean isWin(int[] result) {
        return result[0] == NUMBER_SIZE;
    }

    public int getNumberSize() {
        return NUMBER_SIZE;
    }
}

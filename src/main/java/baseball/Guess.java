package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Guess {
    /**
     * Constant value for the size of baseball guess
     */
    private final int GUESS_SIZE = 3;
    /**
     * List for answer guess
     */
    private List<Integer> computerGuess = new ArrayList<>();
    /**
     * List for user input of guess
     */
    private List<Integer> userGuess = new ArrayList<>();

    /**
     * Sets {@code computerGuess} value randomly without overlapping numbers.
     */
    public void setComputerGuessByRandom() {
        computerGuess.clear();
        while (computerGuess.size() < GUESS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerGuess.contains(randomNumber)) {
                computerGuess.add(randomNumber);
            }
        }
    }

    /**
     * Returns true if the string is only consisted with integers, has length of {@code GUESS_SIZE} , and has no
     * overlapping integers.
     *
     * @param userInput the user input to check validation
     * @return true if {@code userInput} is consisted of {@code GUESS_SIZE} number of integers without overlap , false
     * otherwise
     */
    private boolean checkUserInput(String userInput) {
        if (userInput.length() != GUESS_SIZE) {
            return false;
        }
        for (int i = 0; i < userInput.length(); ++i) {      //input must only have numbers
            char c = userInput.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        for (int i = 0; i < userInput.length() - 1; ++i) {      //input shouldn't have overlapping numbers
            char c = userInput.charAt(i);
            if (userInput.substring(i + 1).contains(c + "")) {      //changes char to charsequence
                return false;
            }
        }
        return true;
    }

    /**
     * Gets user input and saves it at {@code userGuess}, which is cleared first.
     *
     * @throws IllegalArgumentException if {@link Guess#checkUserInput(String)} is false
     */
    public void setUserGuessByInput() throws IllegalArgumentException {
        String userInput = Console.readLine();
        if (!checkUserInput(userInput)) {
            throw new IllegalArgumentException();
        }
        userGuess.clear();
        for (int i = 0; i < userInput.length(); ++i) {
            char c = userInput.charAt(i);
            userGuess.add(c - '0');
        }
    }

    /**
     * @return the number of duplicate values of {@code userGuess} and {@code computerGuess} minus number of strikes by
     * {@link Guess#calculateStrike()}
     */
    public int calculateBall() {
        int ballCount = 0;
        for (int i = 0; i < GUESS_SIZE; ++i) {
            if (computerGuess.contains(userGuess.get(i))) {
                ballCount++;
            }
        }
        return ballCount - calculateStrike();
    }

    /**
     * @return the number of elements that have same index and value
     */
    public int calculateStrike() {
        int strikeCount = 0;
        for (int i = 0; i < GUESS_SIZE; ++i) {
            if (computerGuess.get(i).equals(userGuess.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}

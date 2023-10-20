package baseball.model;

import baseball.view.UserInput;
import java.util.List;

public class Game {

    private final ComputerNumberGenerator computerNumberGenerator;
    private final UserInput userInput;
    public static final String endGame = "3스트라이크";

    public Game(ComputerNumberGenerator computerNumberGenerator, UserInput userInput) {
        this.computerNumberGenerator = computerNumberGenerator;
        this.userInput = userInput;
    }


    public String play() {
        List<Integer> computerNumbers = computerNumberGenerator.getComputerNumber();
        List<Integer> userNumbers = userInput.userInputToIntegerList();

        return getResult(computerNumbers, userNumbers);
    }

    private String getResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (isStrike(computerNumbers, userNumbers, i)) {
                strikes++;
                continue;
            }
            if (isBall(computerNumbers, userNumbers, i)) {
                balls++;
            }
        }

        return formatResult(strikes, balls);
    }

    private boolean isStrike(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {
        return computerNumbers.get(index)
                .equals(userNumbers.get(index));
    }

    private boolean isBall(List<Integer> computerNumbers, List<Integer> userNumbers, int index) {
        return computerNumbers.contains(userNumbers.get(index));
    }

    private String formatResult(int strikes, int balls) {
        if (strikes == 3) {
            return endGame;
        }
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        StringBuilder result = new StringBuilder();
        appendIfNotZero(result, balls, "볼");
        appendIfNotZero(result, strikes, "스트라이크");
        return result.toString();
    }

    private void appendIfNotZero(StringBuilder result, int count, String comment) {
        if (count > 0) {
            result.append(count).append(comment).append(" ");
        }
    }
}

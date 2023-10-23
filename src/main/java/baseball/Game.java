package baseball;

import static baseball.constant.NumberConstants.EXIT_NUMBER_STRING;
import static baseball.constant.NumberConstants.GAME_END_CONDITION;
import static baseball.constant.NumberConstants.RESTART_NUMBER_STRING;
import static baseball.output.GameOutput.*;

import baseball.computer.RandomComputerNumberGenerator;
import baseball.user.UserInput;
import java.util.Objects;

public class Game {

    private final UserInput userInput = new UserInput();

    public Game() {
        printlnStartMessage();
    }

    public void start() {
        String gameStatus = RESTART_NUMBER_STRING;
        while (Objects.equals(gameStatus, RESTART_NUMBER_STRING)) {
            playRound(generateComputerNumberString());
            gameStatus = wantsToRestart();
        }
    }

    private String generateComputerNumberString() {
        return new RandomComputerNumberGenerator().toString();
    }

    private void playRound(String computerNumberString) {
        Result result = new Result(0, 0);
        while (result.strike != GAME_END_CONDITION) {
            result = makeResultCount(userInput.readNumberString(), computerNumberString);
            displayResult(result);
        }

        printStrikeThree(result.strike);
    }

    private Result makeResultCount(String userNumberString, String computerNumberString) {
        int strikeCount = countStrikes(userNumberString, computerNumberString);
        int ballCount = countBallsIncludingStrikes(userNumberString, computerNumberString) - strikeCount;

        return new Result(strikeCount, ballCount);
    }

    private int countStrikes(String userNumberString, String computerNumberString) {
        int count = 0;
        for (int i = 0; i < userNumberString.length(); i++) {
            if (userNumberString.charAt(i) == computerNumberString.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private int countBallsIncludingStrikes(String userNumberString, String computerNumberString) {
        int count = 0;
        for (char c : userNumberString.toCharArray()) {
            if (computerNumberString.contains(Character.toString(c))) {
                count++;
            }
        }

        return count;
    }

    private void displayResult(Result result) {
        if (result.isNothing()) {
            printlnNothing();
            return;
        }

        if (result.ball > 0) {
            printCorrectBallCount(result.ball);
        }

        if (result.strike > 0) {
            printCorrectStrikeCount(result.strike);
        }

        printNewLine();
    }

    private String wantsToRestart() {
        String gameStatus = userInput.readOneOrTwo();
        if (Objects.equals(gameStatus, RESTART_NUMBER_STRING)) {
            return RESTART_NUMBER_STRING;
        }

        printlnEndMessage();
        return EXIT_NUMBER_STRING;
    }

    private record Result(int strike, int ball) {
        boolean isNothing() {
            return strike == 0 && ball == 0;
        }
    }

}

package baseball;

import static baseball.constant.NumberConstants.RESTART_NUMBER_STRING;
import static baseball.constant.NumberConstants.THREE_LENGTH;
import static baseball.output.GameOutput.printCorrectBallCount;
import static baseball.output.GameOutput.printCorrectStrikeCount;
import static baseball.output.GameOutput.printStrikeThree;
import static baseball.output.GameOutput.printlnEndMessage;

import baseball.computer.RandomComputerNumberGenerator;
import baseball.output.GameOutput;
import baseball.user.UserInput;
import java.util.Objects;

public class Game {

    public static void start() {
        GameOutput.printlnStartMessage();
        String gameStatus = RESTART_NUMBER_STRING;

        String computerNumberString = new RandomComputerNumberGenerator().toString();

        while (Objects.equals(gameStatus, RESTART_NUMBER_STRING)) {
            UserInput userInput = new UserInput();
            String userNumberString = userInput.inputNumberString();

            int strikeCount = 0;
            int ballCount = 0;
            for (int i = 0; i < THREE_LENGTH; i++) {
                if (userNumberString.charAt(i) == computerNumberString.charAt(i)) {
                    strikeCount += 1;
                    continue;
                }

                if (computerNumberString.contains(Character.toString(userNumberString.charAt(i)))) {
                    ballCount += 1;
                }
            }

            if (strikeCount == 0 && ballCount == 0) {
                GameOutput.printlnNothing();
                continue;
            }

            if (strikeCount == 3) {
                printStrikeThree(strikeCount);
                gameStatus = userInput.inputOneOrTwo();
                if (Objects.equals(gameStatus, RESTART_NUMBER_STRING)) {
                    computerNumberString = new RandomComputerNumberGenerator().toString();
                    continue;
                }

                printlnEndMessage();
                break;
            }

            if (ballCount > 0) {
                printCorrectBallCount(ballCount);
            }

            if (strikeCount > 0) {
                printCorrectStrikeCount(strikeCount);
            }

            System.out.println();
        }
    }

}

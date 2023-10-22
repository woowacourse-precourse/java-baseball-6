package baseball;

import static baseball.constant.MessageConstants.ASK_ONE_OR_TWO;
import static baseball.constant.MessageConstants.BALL;
import static baseball.constant.MessageConstants.END;
import static baseball.constant.MessageConstants.STRIKE;
import static baseball.constant.MessageConstants.THREE_STRIKE;
import static baseball.constant.NumberConstants.RESTART_NUMBER_STRING;
import static baseball.constant.NumberConstants.THREE_LENGTH;

import baseball.computer.RandomComputerNumberGenerator;
import baseball.output.GameOutput;
import baseball.user.UserInput;
import java.util.Objects;

public class Game {

    public static void start() {
        GameOutput.printlnStartMessage();
        String gameStatus = RESTART_NUMBER_STRING;

        String computerNumberString = new RandomComputerNumberGenerator().toString();

        while (Objects.equals(gameStatus, "1")) {
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
                System.out.println(strikeCount + STRIKE);
                System.out.println(THREE_STRIKE);
                System.out.println(ASK_ONE_OR_TWO);
                gameStatus = userInput.inputOneOrTwo();
                if (Objects.equals(gameStatus, RESTART_NUMBER_STRING)) {
                    computerNumberString = new RandomComputerNumberGenerator().toString();
                    continue;
                }

                System.out.println(END);
                break;
            }

            if (ballCount > 0) {
                System.out.print(ballCount + BALL + " ");
            }

            if (strikeCount > 0) {
                System.out.print(strikeCount + STRIKE);
            }

            System.out.println();
        }
    }

}

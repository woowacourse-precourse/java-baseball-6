package baseball;

import static baseball.validator.NumberValidator.THREE_LENGTH;

import baseball.computer.RandomComputerNumberGenerator;
import baseball.output.GameOutput;
import baseball.user.UserInput;
import java.util.Objects;

public class Game {

    public static void start() {
        GameOutput.printlnStartMessage();
        String gameStatus = "1";

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
                System.out.println(strikeCount + GameOutput.STRIKE);
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameStatus = userInput.inputOneOrTwo();
                if (Objects.equals(gameStatus, "1")) {
                    computerNumberString = new RandomComputerNumberGenerator().toString();
                    continue;
                }

                System.out.println("게임 종료");
                break;
            }

            if (ballCount > 0) {
                System.out.print(ballCount + GameOutput.BALL + " ");
            }

            if (strikeCount > 0) {
                System.out.print(strikeCount + GameOutput.STRIKE);
            }

            System.out.println();
        }
    }

}

package baseball;

import baseball.hint.Ball;
import baseball.hint.Strike;

import java.util.List;

public class Play {
    RandomNumber randomNumber = new RandomNumber();

    public void playBaseball(Input input, Output output, Strike strike, Ball ball) {
        List<Integer> computerNumber = randomNumber.createRandomNumbers();

        while (true) {
            output.printInputMessage();
            String inputNumber = input.input();
            List<Integer> userNumber = input.toNumbers(inputNumber);

            int strikeCount = strike.compare(computerNumber, userNumber);
            int ballCount = ball.compare(computerNumber, userNumber) - strikeCount;

            if (strikeCount == 0 && ballCount == 0) {
                output.printNothingMessage();
            }

            if (ballCount >= 1) {
                output.printBallMessage(ballCount);
            }

            if (strikeCount >= 1) {
                output.printStrikeMessage(strikeCount);
            }

            if (strikeCount == 3) {
                output.printFinishMessage();
                output.printRestartMessage();
                chooseRestartGame(input, output, strike, ball);
                break;
            }

            System.out.println();
        }
    }

    public void chooseRestartGame(Input input, Output output, Strike strike, Ball ball) {
        int inputNumber = Integer.parseInt(input.input());
        if (inputNumber == 1) {
            playBaseball(input, output, strike, ball);
        }
        if (inputNumber == 2) {
            System.out.println("게임 종료");
        }
    }
}

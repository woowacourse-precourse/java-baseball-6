package baseball;

import static baseball.utils.Constants.COUNTS;
import static baseball.utils.GameMessage.GAME_SUCCESS_MESSAGE;
import static baseball.utils.GameMessage.INPUT_REQUEST_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private Computer computer = new Computer();
    private Strike strike;
    private Ball ball;

    public Player() {
    }

    public void init() {
        computer.init();
        strike = new Strike(0);
        ball = new Ball(0);
    }

    public void play() {
        PlayerNumbers playerNumbers;
        while (strike.isLessThan(COUNTS)) {
            System.out.print(INPUT_REQUEST_MESSAGE);
            String playerInput = Console.readLine();
            playerNumbers = new PlayerNumbers(playerInput);

            strike = new Strike(playerNumbers.checkStrikeCount(computer));
            ball = new Ball(playerNumbers.checkBallCount(computer));
            printBallCount();
        }
        printGameSuccessMessage();
    }

    private void printGameSuccessMessage() {
        System.out.println(GAME_SUCCESS_MESSAGE);
    }

    public void printBallCount() {
        String result = "";
        if (ball.getResultMessage().equals("0볼") && strike.getResultMessage().equals("0스트라이크")) {
            result = "낫싱";
        }
        if (ball.getResultMessage().equals("0볼") && !strike.getResultMessage().equals("0스트라이크")) {
            result = strike.getResultMessage();
        }
        if (!ball.getResultMessage().equals("0볼") && strike.getResultMessage().equals("0스트라이크")) {
            result = ball.getResultMessage();
        }
        if (!ball.getResultMessage().equals("0볼") && !strike.getResultMessage().equals("0스트라이크")) {
            result = ball.getResultMessage() + " " + strike.getResultMessage();
        }
        System.out.println(result);
    }
}

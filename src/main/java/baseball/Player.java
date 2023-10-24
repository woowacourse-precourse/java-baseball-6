package baseball;

import static baseball.utils.Constants.COUNTS;
import static baseball.utils.GameMessage.GAME_SUCCESS_MESSAGE;
import static baseball.utils.GameMessage.INPUT_REQUEST_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private Computer computer = new Computer();
    private int strike;
    private int ball;

    public Player() {
    }

    public void init() {
        computer.init();
        strike = 0;
        ball = 0;
    }

    public void play() {
        PlayerNumbers playerNumbers;
        while (strike < COUNTS) {
            System.out.print(INPUT_REQUEST_MESSAGE);
            String playerInput = Console.readLine();
            playerNumbers = new PlayerNumbers(playerInput);

            strike = playerNumbers.checkStrikeCount(computer);
            ball = playerNumbers.checkBallCount(computer);
            printBallCount();
        }
        printGameSuccessMessage();
    }

    private void printGameSuccessMessage() {
        System.out.println(GAME_SUCCESS_MESSAGE);
    }

    public void printBallCount() {
        String result = "";
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        }
        if (ball == 0 && strike > 0) {
            result = strike + "스트라이크";
        }
        if (ball > 0 && strike == 0) {
            result = ball + "볼";
        }
        if (ball > 0 && strike > 0) {
            result = ball + "볼" + " " + strike + "스트라이크";
        }
        System.out.println(result);
    }
}

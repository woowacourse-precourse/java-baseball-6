package baseball.controller;

import baseball.number.PlayerNumbers;
import baseball.number.ComputerNumbers;
import baseball.util.Validate;
import baseball.view.Console;

import java.util.Objects;

public class GameController {
    private final ComputerNumbers computer;
    private static PlayerNumbers player;
    private final Validate validate;

    public GameController () {
        computer = new ComputerNumbers();
        validate = new Validate();
    }

    public void start() {
        do {
            getNumberFromPlayer();
             printCount(getStrikeBallCnt());
        } while (!isEnd());

        Console.printEnding();
        restartGame();
    }

    public void getNumberFromPlayer() {
        player = new PlayerNumbers(Console.setUserNumber());
    }

    public int[] getStrikeBallCnt() {
        return validate.getCompareResult(player.playerInput (), computer.getRandomNumber());
    }

    private void printCount(int[] ballAndStrikeCnt) {
        int balls = ballAndStrikeCnt[0];
        int strikes = ballAndStrikeCnt[1];

        if (balls == 0 && strikes == 0) {
            Console.printNothing ();
        } else if (balls != 0 && strikes != 0) {
            Console.printBallStrike (ballAndStrikeCnt);
        } else if (balls == 0) {
            Console.printOnlyStrike (strikes);
        } else {
            Console.printOnlyBall (balls);
        }
    }

    private void restartGame() {
        String restart = Console.setRegame();
        if (Objects.equals(restart, "1")) {
            GameController newGame = new GameController();
            newGame.start();
        } else if (!Objects.equals(restart, "2")) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2가 아닌 수 입력");
        }
    }

    private boolean isEnd() {
        return validate.isOut();
    }
}
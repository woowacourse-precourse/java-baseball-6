package game;

import camp.nextstep.edu.missionutils.Console;
import player.Player;
import util.GamePrinter;

import java.util.List;

public class Game {

    private Status status;
    private final Player user;
    private final Player otherPlayer;

    private static final int STRIKE_ANSWER = 3;

    public Game(Player user, Player otherPlayer) {
        this.user = user;
        this.otherPlayer = otherPlayer;
        this.status = Status.PLAYING;
    }

    public void run() {
        GamePrinter.startGame();
        do {
            play();
        } while (status.equals(Status.PLAYING));
    }

    public void play() {
        otherPlayer.inputBaseballNumbers();

        BallCount ballCount;
        do {
            GamePrinter.inputNumber();
            user.inputBaseballNumbers();
            ballCount = compareNumbers(user.getBaseballNumbers(), otherPlayer.getBaseballNumbers());
            GamePrinter.resultBallCount(ballCount);
        } while (isNotAnswer(ballCount));

        GamePrinter.isAnswer(STRIKE_ANSWER);

        restartOrExit();
    }

    private BallCount compareNumbers(List<Integer> playerNumbers, List<Integer> otherPlayerNumbers) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < playerNumbers.size(); i++) {
            int playerNumber = playerNumbers.get(i);
            int otherPlayerNumber = otherPlayerNumbers.get(i);

            if (playerNumber == otherPlayerNumber) {
                strike++;
            }

            if (playerNumbers.contains(otherPlayerNumber) && playerNumber != otherPlayerNumber) {
                ball++;
            }
        }

        return new BallCount(strike, ball);
    }

    private void restartOrExit() {
        GamePrinter.restartOrExit();

        String userInput = Console.readLine();

        if (userInput.contentEquals(Status.PLAYING.getValue())) {
            this.status = Status.PLAYING;
        } else if (userInput.contentEquals(Status.EXIT.getValue())) {
            this.status = Status.EXIT;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotAnswer(BallCount ballCount) {
        if (ballCount.getStrikes() == STRIKE_ANSWER) {
            return false;
        }
        return true;
    }
}

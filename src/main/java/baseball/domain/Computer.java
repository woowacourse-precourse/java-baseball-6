package baseball.domain;

import baseball.Input;
import baseball.Output;
import java.util.Arrays;

public class Computer {
    private static final int NEW_GAME_START = 1;
    private static final int CHECK_COUNT = 3;
    private String computerBalls;
    private String userBalls;

    public void startGame(boolean isFirstGame) {
        if (isFirstGame) {
            Output.printStartMessage();
        }

        SelectedBalls newSelectedBalls = SelectedBalls.getNewSelectedBalls();
        this.computerBalls = newSelectedBalls.getStringOfBalls();
        System.out.println("computerBalls = " + computerBalls); //@todo: remove

        while (true) {
            String inputData = Input.inputBalls();
            UserBalls userBalls = new UserBalls(inputData);
            this.userBalls = userBalls.getUserBalls();

            if (isEndGame()) {
                break;
            }
            playGame();
        }

        closeGame();
    }

    private boolean isEndGame() {
        return userBalls.equals(computerBalls);
    }

    private void closeGame() {
        Output.printEndMessage();
        int inputRegame = Input.inputRegame();
        if (inputRegame == NEW_GAME_START) {
            startGame(false);
        }
    }

    private void playGame() {
        if (isNothing()) {
            Output.printNothingMessage();
            return;
        }

        checkBalls();
    }

    private boolean isNothing() {
        return Arrays.stream(computerBalls.split(""))
                .map(Object::toString)
                .noneMatch(userBalls::contains);
    }

    private void checkBalls() {
        int strikeCount = countStrike();
        int ballCount = countBall();
        
        Output.printGameResult(strikeCount, ballCount);
    }

    private int countStrike() {
        int strikeCount = 0;
        for (int i = 0; i < CHECK_COUNT; i++) {
            if (isStrike(i)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    private boolean isStrike(int i) {
        return computerBalls.charAt(i) == userBalls.charAt(i);
    }

    private int countBall() {
        int ballCount = 0;
        for (int i = 0; i < CHECK_COUNT; i++) {
            if (isStrike(i)) {
                continue;
            }
            if (isBall(i)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    private boolean isBall(int i) {
        return computerBalls.contains(String.valueOf(userBalls.charAt(i)));
    }
}

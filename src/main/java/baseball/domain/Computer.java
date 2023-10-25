package baseball.domain;

import baseball.Input;
import baseball.Output;
import java.util.Arrays;
import java.util.stream.Stream;

public class Computer {
    private static final String NEW_GAME_START = "1";
    private static final String EXIT_GAME = "2";
    private static final String INPUT_REGAME_ERROR_MESSAGE = "1 또는 2의 값만 입력해야 합니다.";
    private static final int CHECK_COUNT = 3;
    private String computerBalls;
    private String userBalls;

    public void startGame(boolean isFirstGame) {
        if (isFirstGame) {
            Output.printStartMessage();
        }

        SelectedBalls newSelectedBalls = SelectedBalls.getNewSelectedBalls();
        this.computerBalls = newSelectedBalls.getStringOfBalls();

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
        String inputRegame = Input.inputRegame();
        validateInput(inputRegame);
        if (inputRegame.equals(NEW_GAME_START)) {
            startGame(false);
        }
    }

    private void validateInput(String inputRegame) {
        Stream.of(NEW_GAME_START, EXIT_GAME)
                .filter(str -> str.equals(inputRegame))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INPUT_REGAME_ERROR_MESSAGE));
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
            if (isBall(i)) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    private boolean isBall(int i) {
        return !isStrike(i) && computerBalls.contains(String.valueOf(userBalls.charAt(i)));
    }
}

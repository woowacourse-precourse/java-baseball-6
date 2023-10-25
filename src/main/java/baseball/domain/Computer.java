package baseball.domain;

import baseball.view.View;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {
    public static final String RESTART_COMMAND = "1";
    public static final String FINISH_COMMAND = "2";
    public static final int NUMBER_SIZE = 3;

    private boolean isRunning;

    public void run() {
        View.printGameStartMessage();

        this.isRunning = true;
        while (isRunning) {
            Game.makeNewGame(this).start();
        }
    }

    public List<Integer> generateTargetNumber() {
        List<Integer> targetNumber = new ArrayList<>();
        while (targetNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumber.contains(randomNumber)) {
                targetNumber.add(randomNumber);
            }
        }

        return targetNumber;
    }

    public void checkFinishCommand(String command) {
        if (command.equals(FINISH_COMMAND)) {
            shutDown();
        }
    }

    private void shutDown() {
        this.isRunning = false;
    }

    public static void validatePlayerNumber(String playerNumber) {
        validateIsNumber(playerNumber);
        validateNumberSize(playerNumber);
        validateNumberRange(playerNumber);
        validateDuplicatedNumber(playerNumber);
    }

    private static void validateIsNumber(String playerNumber) {
        try {
            Integer.parseInt(playerNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    private static void validateNumberSize(String playerNumber) {
        if (playerNumber.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("반드시 3개의 숫자여야 합니다.");
        }
    }

    private static void validateNumberRange(String playerNumber) {
        if (playerNumber.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력이 가능합니다.");
        }
    }

    private static void validateDuplicatedNumber(String playerNumber) {
        long count = Arrays.stream(playerNumber.split("")).distinct().count();

        if (count != NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public static void validateEndCommandType(String command) {
        if (!command.equals(FINISH_COMMAND) && !command.equals(RESTART_COMMAND)) {
            throw new IllegalArgumentException("잘못된 종료 커멘드입니다.");
        }
    }
}

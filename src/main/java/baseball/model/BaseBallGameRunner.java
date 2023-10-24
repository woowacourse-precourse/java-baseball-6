package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.GameStatus.GUESS_WRONG;

public class BaseBallGameRunner {
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String INVALID_INPUT_MESSAGE = "잘못된 입력값입니다.";
    private final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String USER_ACTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final Computer computer;
    private final GuessResultGenerator generator;
    private final List<Integer> guessNumber;

    public BaseBallGameRunner() {
        this.computer = new Computer();
        this.generator = new GuessResultGenerator();
        this.guessNumber = new ArrayList<>();
    }

    public void run() {
        System.out.println(START_MESSAGE);
        while (true) {
            String inputString = getPlayerInput(INPUT_MESSAGE);
            validateInputAndAddToList(inputString, guessNumber);

            GuessResult result = generator.generateResult(computer.getHiddenNumber(), guessNumber);
            boolean isGameOngoing = processResult(result);
            if (!isGameOngoing) {
                break;
            }
        }
        Console.close();
    }

    private void reset() {
        guessNumber.clear();
        generator.resetIsMatched();
    }

    private void resetForNewGame() {
        reset();
        computer.resetForNewGame();
    }

    private boolean processUserAction(String userAction) {
        if (userAction.equals("1")) {
            return true;
        }
        if (userAction.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
    }

    private String getPlayerInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }

    private void validateInputAndAddToList(String inputString, List<Integer> guessNumber) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        for (int i = 0; i < 3; i++) {
            char c = inputString.charAt(i);
            checkDigitAndDuplicate(c, guessNumber);
            guessNumber.add(c - '0');
        }
    }

    private void checkDigitAndDuplicate(char c, List<Integer> guessNumber) {
        if ((c >= '1' && c <= '9') && !guessNumber.contains(c - '0'))
            return;
        throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
    }

    private boolean processResult(GuessResult result) {
        System.out.println(result.getResultMessage());

        if (result.getStatus().equals(GUESS_WRONG)) {
            reset();
            return true;
        }

        System.out.println(GAME_FINISH_MESSAGE);
        String userAction = getPlayerInput(USER_ACTION_MESSAGE);
        boolean playAgain = processUserAction(userAction);
        if (!playAgain) {
            return false;
        }
        resetForNewGame();
        return true;
    }
}

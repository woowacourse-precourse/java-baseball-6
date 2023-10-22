package baseball;

import baseball.model.BaseballNumber;
import baseball.model.BaseballNumbers;
import baseball.model.Game;
import baseball.model.JudgeResult;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static final String NUMBER_INPUT_ERROR = "숫자를 입력해야 합니다.";
    private static final String DIGIT_REGEXP = "[0-9]*";
    private static final String RESTART_INPUT_ERROR = "1 또는 2를 입력해야 합니다.";
    private static final String ONE_OR_TWO_REGEXP = "[1|2]";
    private static final int RESTART = 1;
    private static final int STOP = 2;

    private final View view;
    private final Game game;

    public Controller(View view, Game game) {
        this.view = view;
        this.game = game;
    }

    public void run() {
        view.printProgramStart();
        do {
            startGame();
            view.printGameOver();
        } while (shouldRestart());
        view.printExitGame();
    }

    private boolean shouldRestart() {
        int restartNum;
        String restartInput = view.getRestartInput();
        validOneOrTwo(restartInput);
        restartNum = Integer.parseInt(restartInput);
        return restartNum == RESTART;
    }

    private static void validOneOrTwo(String restartInput) {
        if (!restartInput.matches(ONE_OR_TWO_REGEXP)) {
            throw new IllegalArgumentException(RESTART_INPUT_ERROR);
        }
    }

    private void startGame() {
        game.init();
        while (!game.isGameOver) {
            String userInput = view.getUserNumberInput();
            validDigitPattern(userInput);
            BaseballNumbers userBaseballNumbers = baseballNumbersByUser(userInput);
            JudgeResult judgeResult = game.judge(userBaseballNumbers);
            view.printJudgeResult(judgeResult);
        }
    }

    private static BaseballNumbers baseballNumbersByUser(String userInput) {
        List<BaseballNumber> baseballNumberList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            int parseInt = Integer.parseInt(Character.toString(c));
            BaseballNumber userBaseballNumber = BaseballNumber.of(parseInt);
            baseballNumberList.add(userBaseballNumber);
        }
        return new BaseballNumbers(baseballNumberList);
    }

    private static void validDigitPattern(String userInput) {
        if (!isDigit(userInput)) {
            throw new IllegalArgumentException(NUMBER_INPUT_ERROR);
        }
    }

    private static boolean isDigit(String userInput) {
        return userInput.matches(DIGIT_REGEXP);
    }
}

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
    private static final String RESTART_INPUT_ERROR = "게임을 다시 시작하려면 1을, 종료하려면 2를 입력해야 합니다.";
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
        validateOneOrTwo(restartInput);
        restartNum = Integer.parseInt(restartInput);
        return restartNum == RESTART;
    }

    private static void validateOneOrTwo(String restartInput) {
        if (!restartInput.matches(ONE_OR_TWO_REGEXP)) {
            throw new IllegalArgumentException(RESTART_INPUT_ERROR);
        }
    }

    private void startGame() {
        game.init();
        while (!game.isGameOver()) {
            playRound();
        }
    }


    private void playRound() {
        BaseballNumbers userBaseballNumbers = getUserBaseballNumbers();
        JudgeResult judgeResult = game.judge(userBaseballNumbers);
        view.printJudgeResult(judgeResult);
    }

    private BaseballNumbers getUserBaseballNumbers() {
        String userInput = view.getUserNumberInput();
        validateDigitPattern(userInput);
        return baseballNumbersByUser(userInput);
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

    private static void validateDigitPattern(String userInput) {
        if (!isDigit(userInput)) {
            throw new IllegalArgumentException(NUMBER_INPUT_ERROR);
        }
    }

    private static boolean isDigit(String userInput) {
        return userInput.matches(DIGIT_REGEXP);
    }
}

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
    private static final String ONE_OR_TWO_REGEXP = "[1|2]{1}";
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    private void startGame() {
        Game game = new Game();
        while (!game.isGameOver) {
            String userInput = view.getUserNumberInput();
            validDigitPattern(userInput);
            BaseballNumbers userBaseballNumbers = baseballNumbersByUser(userInput);
            JudgeResult judgeResult = game.judge(userBaseballNumbers);
            view.printJudgeResult(judgeResult);
        }
    }

    private void restartGame() {

    }

    private static BaseballNumbers baseballNumbersByUser(String userInput) {
        List<BaseballNumber> baseballNumberList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            baseballNumberList.add(BaseballNumber.of((int) c));
        }
        return new BaseballNumbers(baseballNumberList);
    }

    private static void validDigitPattern(String userInput) {
        if (!isDigit(userInput)) {
            throw new IllegalArgumentException(NUMBER_INPUT_ERROR);
        }
    }

    private static boolean isDigit(String userInput) {
        return userInput.matches("[0-9]*");
    }
}

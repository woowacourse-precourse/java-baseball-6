package baseball;

import baseball.Util.Util;
import baseball.model.BaseballModel;
import baseball.model.Score;
import baseball.view.BaseballView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballModel model = new BaseballModel();
        BaseballView view = new BaseballView();
        while (true) {
            model.generateAnswer();
            view.printStartMessage();

            Score score;
            do {
                String guessInput = view.getPlayerGuess();
                validateGuess(guessInput);
                List<Integer> playerGuess = Util.parseStringToIntegerList(guessInput);
                score = model.calculateScore(playerGuess);
                view.printGameResult(score);
            } while (!score.isThreeStrike());

            view.printEndMessage();

            String choiceInput = view.getPlayerChoice();
            validateChoice(choiceInput);
            if (choiceInput.equals("2")) {
                break;
            }
        }
    }

    public static void validateGuess(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 입력값은 허용되지 않습니다.");
        }
        if (!Util.isLengthThree(input)) {
            throw new IllegalArgumentException("입력값의 길이는 3자리여야 합니다.");
        }
        if (!Util.isAllPositiveInteger(input)) {
            throw new IllegalArgumentException("입력값의 모든 문자는 양의 정수여야 합니다.");
        }
        if (!Util.isAllUniqueCharacter(input)) {
            throw new IllegalArgumentException("입력값에 문자들은 중복이 없어야 합니다.");
        }
    }

    public static void validateChoice(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 입력값은 허용되지 않습니다.");
        }
        if (!Util.isOneOrTwo(input)) {
            throw new IllegalArgumentException("입력값은 1 또는 2여야 합니다.");
        }
    }
}

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
            } while (score.getStrike() != 3);

            view.printEndMessage();

            String choiceInput = view.getPlayerChoice();
            validateChoice(choiceInput);
            if (choiceInput.equals("2")) {
                break;
            }
        }
    }

    public static void validateGuess(String input) {
        if (!Util.isLengthThree(input)) {
            throw new IllegalArgumentException("유효한 입력값이 아닙니다.");
        }
        if (!Util.isAllPositiveInteger(input)) {
            throw new IllegalArgumentException("유효한 입력값이 아닙니다.");
        }
        if (!Util.isAllUniqueCharacter(input)) {
            throw new IllegalArgumentException("유요한 입력값이 아닙니다.");
        }
    }

    public static void validateChoice(String input) {
        if (!Util.isOneOrTwo(input)) {
            throw new IllegalArgumentException("유효한 입력값이 아닙니다");
        }
    }
}

package baseball;

import domain.HintEvaluator;
import domain.InputValidator;
import domain.NumberGenerator;

import java.util.List;

public class Game {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final InputValidator inputValidator = new InputValidator();
    private final HintEvaluator hintEvaluator = new HintEvaluator();

    public void start() {
        boolean continueGame = true;
        while (continueGame) {
            playSingleGame();
            continueGame = isContinue();
        }
    }

    private void playSingleGame() {
        List<Integer> computerNumbers = numberGenerator.generateRandomNumbers();

        System.out.print("숫자를 입력해주세요 : ");

        while (true) {
            String userInput = inputValidator.validateAndReturnInput();
            String hint = hintEvaluator.evaluate(computerNumbers, userInput);

            if ("3스트라이크".equals(hint)) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }

            System.out.println(hint);

        }
    }

    private boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = inputValidator.validateAndReturnGameContinuationChoice();

        if ("1".equals(choice)) {
            return true;
        } else if ("2".equals(choice)) {
            System.out.println("게임 종료");
            return false;
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return isContinue();
        }
    }
}
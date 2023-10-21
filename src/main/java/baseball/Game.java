package baseball;

import baseball.calculator.ResultCalculator;
import baseball.generator.NumberGenerator;
import baseball.handler.UserInputHandler;

public class Game {

    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final ResultCalculator resultCalculator = new ResultCalculator();
    private boolean isCorrect;

    public Game() {
        this.isCorrect = false;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        String computerNumber = numberGenerator.generateRandomNumber();
        while (!isCorrect) {
            String userInputNumber = userInputHandler.askUserInputNumber();
            String result = resultCalculator.calculateResult(userInputNumber, computerNumber);
            System.out.println(result);
            isCorrect = result.contains("3개의 숫자를 모두 맞히셨습니다!");
        }
    }

    public boolean Restart() {
        isCorrect = false;
        return userInputHandler.askRestart();
    }
}

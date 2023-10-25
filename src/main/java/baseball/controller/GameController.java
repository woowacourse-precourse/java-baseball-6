package baseball.controller;

import baseball.view.GameView;
import baseball.view.UserInputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final GameView gameView;
    private final UserInputView userInputView;
    private final ValidationController validationController;
    private final GameResultController gameResultController;
    private final RandomNumberGenerator randomNumberGenerator;

    public GameController() {
        this.gameView = new GameView();
        this.userInputView = new UserInputView();
        this.validationController = new ValidationController();
        this.gameResultController = new GameResultController();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void startGame() {
        gameView.startGameView();
        while (true) {

            List<Integer> computerNumber = randomNumberGenerator.generateRandomComputerNumber();

            while (true) {
                String userInput = userInputView.requestNumberInput();
                validationController.validateInput(userInput);

                List<Integer> userNumber = new ArrayList<>();
                for (char ch : userInput.toCharArray()) {
                    userNumber.add(Character.getNumericValue(ch));
                }

                String result = gameResultController.calculateResult(computerNumber, userNumber);

                System.out.println(result);

                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = userInputView.requestNumberInput();

            if ("2".equals(userInput)) {
                break;
            }
            if (!"1".equals(userInput)) {
                break;
            }
        }
    }
}

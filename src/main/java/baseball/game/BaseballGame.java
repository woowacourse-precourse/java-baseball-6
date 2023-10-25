package baseball.game;

import baseball.util.BaseballNumberGenerator;
import baseball.util.GameResult;
import baseball.util.UserInputManager;

import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private String userGuess;

    private final BaseballNumberGenerator numberGenerator = new BaseballNumberGenerator();
    private final UserInputManager inputManager = new UserInputManager();
    private final GameResult gameResult = new GameResult();

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void playGame() {
        initializeGame();

        while (true) {
            userGuess = inputManager.getUserInput();
            inputManager.validateUserInput(userGuess);

            gameResult.calculateResult(userGuess, computerNumbers);
            System.out.println(gameResult.getResultMessage());

            if (gameResult.isGameWon()) {
                if(inputManager.askForReplay()){
                    initializeGame();
                }else{
                    break;
                }
            }
        }
    }

    private void initializeGame() {
        computerNumbers = numberGenerator.generateRandomNumbers();
    }
}
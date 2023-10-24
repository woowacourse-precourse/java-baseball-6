package baseball.controller;

import java.util.List;

public class GameController {

    private final String GAME_START_GUIDE = "숫자 야구 게임을 시작합니다.";

    private ComputerController computerController = new ComputerController();

    private PlayerController playerController = new PlayerController();

    public GameController() {
        System.out.println(GAME_START_GUIDE);
    }

    public void playGame() {
        Boolean isRunning = true;
        while (isRunning) {
            computerController.saveRandomNumbers();
            proceedGame();
        }
    }

    private void proceedGame() {
        Boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            List<Integer> inputNumbers = playerController.readAndValidateInputNumbers();
            computerController.provideHint(inputNumbers);
        }
    }
}

package baseball.controller;

import java.util.List;

public class GameController {

    private final String GAME_START_GUIDE = "숫자 야구 게임을 시작합니다.";
    private final String CORRECT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String GAME_RESTART_OR_OVER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

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
            isRunning = askIfContinue();
        }
    }

    private void proceedGame() {
        Boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            List<Integer> inputNumbers = playerController.readAndValidateInputNumbers();
            computerController.provideHint(inputNumbers);
        }
    }

    private Boolean askIfContinue() {
        System.out.println(CORRECT_ANSWER_MESSAGE);
        System.out.println(GAME_RESTART_OR_OVER);
    }
}

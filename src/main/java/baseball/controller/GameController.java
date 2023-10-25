package baseball.controller;

import baseball.service.BaseballService;

public class GameController {
    public BaseballController baseballController = new BaseballController();
    public BaseballService baseballService = new BaseballService();

    private boolean isCorrectGuess = false;
    public void Init() {
        baseballService.startNewGame();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!isCorrectGuess) {
            baseballController.readUserNumber();
            int[] gameResult = baseballService.getGameResult();
            System.out.println(baseballService.convertResultToString(gameResult));
            isCorrectGuess = baseballService.isCorrectGuess(gameResult[0]);
        }
    }

}

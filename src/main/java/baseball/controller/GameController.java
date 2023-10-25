package baseball.controller;

import baseball.service.BaseballService;

public class GameController {
    private static final int NEW_GAME = 1;
    private boolean isCorrectGuess = false;

    public BaseballController baseballController = new BaseballController();
    public BaseballService baseballService = new BaseballService();

    public void Init() {
        int gameStatus = NEW_GAME;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameStatus == NEW_GAME) {
            baseballService.startNewGame();
            while (!isCorrectGuess) {
                baseballController.readUserNumber();
                int[] gameResult = baseballService.getGameResult();
                System.out.println(baseballService.convertResultToString(gameResult));
                isCorrectGuess = baseballService.isCorrectGuess(gameResult[0]);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameStatus = baseballController.askForNewGameOrExit();
            isCorrectGuess = false;
        }
    }
}

package baseball.controller;

import baseball.view.GameService;

public class BaseballGame {
    GameService gameService = new GameService();

    private static final int N = 3;

    public void startGame() {
        gameService.generateNdigitAnswer(N);

        //숫자를 맞혀 게임이 종료될 때까지
        //사용자 입력을 받고 비교 결과 출력 반복
        while (!gameService.getFinishFlag()) {
            gameService.getUserInput();
            gameService.printResult();
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}

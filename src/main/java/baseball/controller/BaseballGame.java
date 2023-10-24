package baseball.controller;

import baseball.view.GameService;

public class BaseballGame {
    GameService gameService = new GameService();

    public void startGame() {

        //숫자를 맞혀 게임이 종료될 때까지
        //사용자 입력을 받아 컴퓨터 정답과 비교한 후 결과 출력
        while (!gameService.getFinishFlag()) {
            gameService.setUserInput();
            System.out.println(gameService.compare());
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}

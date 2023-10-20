package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.GameService;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGame {
    public void GameStart() {
        OutputView outputView = new OutputView();
        ComputerService computerService = new ComputerService();
        GameService gameService = new GameService();

        boolean cond = true;
        List<Integer> computer;

        outputView.StartGame(); // 게임 시작 메시지 출력

        while(cond) { // 사용자가 종료할 때까지 반복
            computer = computerService.ComputerNumberInput(); // 컴퓨터 랜덤 수 생성
            cond = gameService.GameProcess(computer); // 게임 시작
        }
    }
}

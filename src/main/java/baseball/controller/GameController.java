package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameManager;
import baseball.model.User;
import baseball.service.MatchService;
import baseball.view.Input;
import baseball.view.Print;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    // model
    private Computer computer;
    private User user;
    private GameManager gameManager;

    // view
    private Input input;
    private Print print;

    // service
    private MatchService matchService;

    public GameController(Computer computer, User user, GameManager gameManager, Input input, Print print, MatchService matchService) {
        this.computer = computer;
        this.user = user;
        this.gameManager = gameManager;
        this.input = input;
        this.print = print;
        this.matchService = matchService;
    }

    public void run() {
        // 숫자 야구 게임을 시작합니다.
        print.printInit();
        // 컴퓨터 숫자 생성
        computer.generate();
        // 결과 리스트 생성
        List<Integer> result = new ArrayList<>();
        // 게임 모드 설정
        gameManager.setGameMode("1");

        // gameMode = 1일때 계속해서 게임 실행
        while(gameManager.getGameMode().equals("1")) {
            // 결과 초기화
            result.clear();
            // 숫자를 입력해주세요 :
            input.inputUserNumber();
            // user에 초기화 후 userNumber 셋팅
            user.resetUserNumber();
            user.setUserNumber(input.getUserNumber());
            // 매칭 결과
            result = matchService.getResult(computer.getComNumber(), user.getUserNumber());
            // 맞췄을 때
            if(result.get(1).equals(3)) {
                // 3개의 숫자를 모두 맞히셨습니다! 게임 종료
                print.printWin();
                // 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
                input.endGame();
                if(input.getGameMode().equals("2")){
                    // 루프를 벗어나 종료
                    gameManager.setGameMode("2");
//                    break;
                }
                // 컴퓨터 숫자 초기화 후 재생성
                computer.getComNumber().clear();
                computer.generate();
            } else {    // 못 맞췄을 때
                print.printResult(result.get(0), result.get(1));
            }
        }
    }
}

package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameManager;
import baseball.model.GameResult;
import baseball.model.User;
import baseball.service.GameService;
import baseball.view.Input;
import baseball.view.Print;


import static baseball.model.GameMode.END;
import static baseball.model.GameMode.PLAY;

public class GameController {
    // model
    private Computer computer;
    private User user;
    private GameManager gameManager;

    // view
    private Input input;
    private Print print;

    // service
    private GameService gameService;

    // 변수
    private static final String GAME_MODE_PLAY = "1";
    private static final String GAME_MODE_END = "2";
    private static final int WIN_CONDITION = 3;

    public GameController(Computer computer, User user, GameManager gameManager, Input input, Print print, GameService gameService) {
        this.computer = computer;
        this.user = user;
        this.gameManager = gameManager;
        this.input = input;
        this.print = print;
        this.gameService = gameService;

        gameManager.setGameMode(GAME_MODE_PLAY);
    }

    public void run() {
        // 숫자 야구 게임을 시작합니다.
        print.printInit();
        // 컴퓨터 숫자 생성
        computer.generate();

        // gameMode = 1일때 계속해서 게임 실행
        while(gameManager.getGameMode() == PLAY) {
            // 숫자를 입력해주세요 :
            user.setUserNumber(input.inputUserNumber());
            // 매칭 결과
            GameResult result = gameService.getResult(computer.getComNumber(), user.getUserNumber());
            // 맞췄을 때
            if(result.getStrike() == WIN_CONDITION) {
                // 3개의 숫자를 모두 맞히셨습니다! 게임 종료
                print.printWin();
                // 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
                gameManager.setGameMode(input.endGame());
                if(gameManager.getGameMode() == END){
                    break;  // 루프를 벗어나기 위해
                }
                // 컴퓨터 숫자 초기화 후 재생성
                computer.getComNumber().clear();
                computer.generate();
            } else {    // 못 맞췄을 때
                print.printResult(result.getBall(), result.getStrike());
            }
        }
    }
}

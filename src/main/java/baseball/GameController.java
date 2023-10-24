package baseball;

/**
 * 게임 시작 ~ 종료까지의 흐름과 종료 후 사용자 입력 값에 따른 애플리케이션 재시작 / 종료를 제어하는 클래스
 */
public class GameController {
    GameService gameService = new GameService();

    void startGame() {
        boolean restart = true;
        while (restart) {
            gameService.playGame();
            // 유저가 재시작 요청 시 while loop으로 재시작 제어(스택 오버플로우 방지)
            restart = gameService.exit();
        }
    }
}

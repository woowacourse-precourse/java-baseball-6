package baseball;

public class GameController {

    private final Game game;
    private final GameView gameView;

    GameController() {
        this.game = new Game();
        this.gameView = new GameView();
    }

    public void init() {
        gameView.printStartGame();  // 게임 시작 문구 출력
        game.pickRandomNumbers();   // 게임의 정답 설정

        while (true) {
            String userInput = gameView.inputNumber();  // userInput 입력 받기
            game.setUserInput(userInput);               // 게임 객체에 userInput 할당
            game.checkAnswer();                         // 정답 확인

            if (gameView.checkAndPrintResult(game)) {   // 결과 확인 및 출력
                gameView.printExitGame();               // 게임 종료 문구 출력
                if (!gameView.inputRestartOption()) {   // 종료를 원하면 break
                    break;
                }
                game.pickRandomNumbers();               // 게임의 정답 재설정
            }
        }
    }
}

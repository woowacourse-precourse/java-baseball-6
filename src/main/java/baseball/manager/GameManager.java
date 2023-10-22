package baseball.manager;

import baseball.io.InputHandler;
import baseball.model.Baseball;
import baseball.model.Game;

import static baseball.constant.Constants.*;

public class GameManager {
    private final InputHandler inputHandler;

    public GameManager() {
        inputHandler = new InputHandler();
    }

    public void play() {
        int restart;
        // 게임 시작 메시지 출력
        System.out.println(GAME_START_MESSAGE);

        do {
            // Game 초기화 init? -> random 값 생성
            Game game = new Baseball(inputHandler);
            // 게임 실행
            game.playGame();
            System.out.println(INPUT_RESTART_MESSAGE);
            restart = inputHandler.scanInteger();
        } while (restart == INPUT_RESTART);
    }
}

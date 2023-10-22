package baseball.manager;

import baseball.io.InputHandler;
import baseball.io.OutputHandler;
import baseball.model.Baseball;
import baseball.model.Game;
import baseball.validation.InputValidation;

import static baseball.constant.Constants.*;

public class GameManager {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public GameManager() {
        inputHandler = new InputHandler();
        outputHandler = new OutputHandler();
    }

    public void play() {
        int restart;
        // 게임 시작 메시지 출력
        outputHandler.printMessage(GAME_START_MESSAGE);
        do {
            // Game 초기화 init? -> random 값 생성
            Game game = new Baseball(inputHandler, outputHandler);
            // 게임 실행
            game.playGame();
            outputHandler.printMessage(INPUT_RESTART_MESSAGE);
            restart = inputHandler.scanInteger();
            if(!InputValidation.isRestartInput(restart)) throw new IllegalArgumentException();
        } while (restart == INPUT_RESTART);
    }
}

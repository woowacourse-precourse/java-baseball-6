package baseball.controller;

import baseball.model.GameState;
import baseball.view.GameInput;
import baseball.view.GameOutput;

public class GameController {

    /* Controller */
    PlayController playController;
    ValidateController validateController;
    GenerateController generateController;

    /* View */
    GameInput gameInput;
    GameOutput gameOutput;

    /* Model */
    GameState gameState;

    public GameController() {
        this.gameInput = new GameInput();
        this.gameOutput = new GameOutput();
        this.gameState = new GameState();
        this.generateController = new GenerateController();
        this.validateController = new ValidateController();
        this.playController = new PlayController(gameState.getMaximumNumberLength());
    }

    public void startGame() {
        gameOutput.printStartGame();
        boolean statePool;

        while (gameState.getState()) {
            gameState.setSuccess(false);
            playController.generateNumber(); // 컴퓨터 난수 생성
            guessNumber(); // 게임 시작
            statePool = endOrRestart();
            gameState.setState(statePool);
        }
    }

    private void guessNumber() { // 본 게임 로직
        boolean successPool;

        while (!gameState.getSuccess()) {
            String input = gameInput.inputNumber(); // 유저 입력
            Integer maximumNumberLength = gameState.getMaximumNumberLength();
            validateController.validateInputString(input, maximumNumberLength); // 입력 검사
            successPool = playController.isSuccess(input); // 정답 검사
            gameState.setSuccess(successPool);
        }

        gameOutput.printEndGame();
    }



    private boolean endOrRestart() {
        String input = gameInput.inputEndOrRestart();
        validateController.validateInputString(input);

        return userAnswer(input);
    }

    private boolean userAnswer(String input) {
        if (input.equals(gameState.getRestartFlag())) { // 1
            return true;
        } else if (input.equals(gameState.getEndFlag())) { // 2
            return false;
        }

        throw new IllegalArgumentException("처리되지 않은 에러입니다.");
    }
}

package baseball.controller;

import baseball.view.GameInput;
import baseball.view.GameOutput;

public class GameController {
    private static final String RESTART_FLAG = "1";
    private static final String END_FLAG = "2";
    private final Integer MAXIMUM_NUMBER_LENGTH = 3;
    private boolean state;
    PlayController playController;
    ValidateController validateController;
    GenerateController generateController;
    GameInput gameInput;
    GameOutput gameOutput;

    public GameController() {
        this.generateController = new GenerateController();
        this.validateController = new ValidateController();
        this.playController = new PlayController(this.MAXIMUM_NUMBER_LENGTH);
        this.gameInput = new GameInput();
        this.gameOutput = new GameOutput();

        state = true;
    }

    public void startGame() {
        gameOutput.printStartGame();

        while (state) {
            playController.generateNumber(); // 컴퓨터 난수 생성
            guessNumber(); // 게임 시작
            state = endOrRestart();
        }
    }

    private void guessNumber() { // 본 게임 로직
        boolean success = false; //  정답을 맞췄는지 여부

        while (!success) {
            String input = gameInput.inputNumber();
            validateController.validateInputString(input, MAXIMUM_NUMBER_LENGTH);
            success = playController.isSuccess(input);
        }

        gameOutput.printEndGame();
    }



    private boolean endOrRestart() {
        String input = gameInput.inputEndOrRestart();
        validateController.validateInputString(input);

        return userAnswer(input);
    }

    private boolean userAnswer(String input) {
        if (input.equals(RESTART_FLAG)) { // 1
            return true;
        } else if (input.equals(END_FLAG)) { // 2
            return false;
        }

        throw new IllegalArgumentException("처리되지 않은 에러입니다.");
    }
}

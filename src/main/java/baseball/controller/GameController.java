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
        this.playController = new PlayController(this.generateController, MAXIMUM_NUMBER_LENGTH);
        this.gameInput = new GameInput();
        this.gameOutput = new GameOutput();

        state = true;
    }

    public void startGame() {
        gameOutput.printStartGame(); // 시작 문구를 출력

        while (state) {
            playController.generateNumber(); // 컴퓨터 난수 생성
            guessNumber(); // 게임 시작
            state = endOrRestart(); // 재시작 여부
        }
    }

    private void guessNumber() { // 본 게임 로직
        boolean success = false; //  정답을 맞췄는지 여부

        while (!success) {
            String input = gameInput.inputNumber();
            try {
                    if (validateController.validateInputString(input, MAXIMUM_NUMBER_LENGTH))
                    success = playController.isSuccess(input);
            } catch (IllegalArgumentException e) {
                System.out.println("입력 형식이 잘못되었습니다.");
            }
        }
    }
}

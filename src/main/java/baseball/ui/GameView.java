package baseball.ui;

import baseball.controller.GameController;

public class GameView {

    private final GameController gameController;
    private final UserInputValidator validator;
    private final InputComponent inputComponent;

    public GameView(GameController gameController, UserInputValidator validator, InputComponent inputComponent) {
        this.gameController = gameController;
        this.validator = validator;
        this.inputComponent = inputComponent;
    }

    public void start() {
        gameController.start();
        System.out.println("숫자 야구 게임을 시작합니다.");
        guessUntilCorrect();
    }

    public void guessUntilCorrect() {
        while (gameController.isStillWrong()) {
            guess();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void guess() {
        System.out.print("숫자를 입력해주세요 : ");
        String validUserAnswer = validator.check(inputUserAnswer());
        gameController.checkAnswer(validUserAnswer);
    }

    private String inputUserAnswer() {
        return inputComponent.getUserAnswer();
    }

}

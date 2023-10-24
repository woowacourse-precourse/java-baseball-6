package baseball.ui;

import baseball.controller.GameController;
import java.util.Map;

public class GameView {

    private final GameController gameController;
    private final UserInputValidator validator;
    private final InputComponent inputComponent;
    private final OutputComponent outputComponent;
    private final ResultFormatStringCreator creator;

    public GameView(GameController gameController, UserInputValidator validator, InputComponent inputComponent,
                    OutputComponent outputComponent, ResultFormatStringCreator creator) {
        this.gameController = gameController;
        this.validator = validator;
        this.inputComponent = inputComponent;
        this.outputComponent = outputComponent;
        this.creator = creator;
    }

    public void start() {
        gameController.start();
        outputComponent.print("숫자 야구 게임을 시작합니다.\n");
        guessUntilCorrect();
    }

    public void guessUntilCorrect() {
        while (gameController.isStillWrong()) {
            guess();
        }
        outputComponent.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    private void guess() {
        outputComponent.print("숫자를 입력해주세요 : ");
        String validUserAnswer = validator.check(inputUserAnswer());
        Map<String, Integer> resultMap = gameController.checkAnswer(validUserAnswer);
        System.out.println(creator.toString(resultMap));
    }

    private String inputUserAnswer() {
        return inputComponent.getUserAnswer();
    }

}

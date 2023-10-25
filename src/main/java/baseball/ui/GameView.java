package baseball.ui;

import baseball.controller.GameController;
import baseball.controller.GameControllerImpl;
import baseball.controller.RandomNumberCreator;
import baseball.controller.Scoring;
import java.util.Map;

public class GameView {

    private GameController gameController;
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

        flowAfterCorrect();
    }

    private void guess() {
        outputComponent.print("숫자를 입력해주세요 : ");
        String validUserAnswer = validator.check(inputUserAnswer());
        Map<String, Integer> resultMap = gameController.checkAnswer(validUserAnswer);
        System.out.println(creator.toString(resultMap));
    }

    private void flowAfterCorrect() {
        outputComponent.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        int validUserChoice = validator.checkResume(inputComponent.getUserResumeChoice());
        determineFlow(validUserChoice);
    }

    private void determineFlow(int validUserChoice) {
        if (validUserChoice == 1 && gameController.isAbleToRestart()) {
            this.restart();
        } else if (validUserChoice == 2 && gameController.isAbleToTerminate()) {
            outputComponent.print("게임 종료");
        }
    }

    public void restart() {
        this.gameController = new GameControllerImpl(new Scoring(RandomNumberCreator.create(3)));
        this.gameController.start();
        guessUntilCorrect();
    }

    private String inputUserAnswer() {
        return inputComponent.getUserAnswer();
    }

}

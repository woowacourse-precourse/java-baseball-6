package baseball.ui;

import baseball.controller.GameController;
import baseball.controller.GameControllerFactory;
import baseball.state.ScoringFactory;
import baseball.ui.input.component.InputComponent;
import baseball.ui.output.component.OutputComponent;
import baseball.ui.output.format.ResultFormatStringCreator;
import java.util.Map;

public class GameView {
    private ScoringFactory scoringFactory;
    private GameControllerFactory gameControllerFactory;

    private GameController gameController;
    private final InputComponent inputUserAnswer;
    private final InputComponent inputUserResume;
    private final OutputComponent outputComponent;
    private final ResultFormatStringCreator creator;

    public GameView(ScoringFactory scoringFactory, GameControllerFactory gameControllerFactory,
                    InputComponent inputUserAnswer, InputComponent inputUserResume,
                    OutputComponent outputComponent, ResultFormatStringCreator creator) {
        this.gameController = gameControllerFactory.get(scoringFactory);
        this.scoringFactory = scoringFactory;
        this.gameControllerFactory = gameControllerFactory;
        this.inputUserAnswer = inputUserAnswer;
        this.inputUserResume = inputUserResume;
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
        String validUserAnswer = inputUserAnswer.getValidUserInput();
        Map<String, Integer> resultMap = gameController.checkAnswer(validUserAnswer);
        System.out.println(creator.toString(resultMap));
    }

    private void flowAfterCorrect() {
        outputComponent.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String validUserChoice = inputUserResume.getValidUserInput();
        determineFlow(validUserChoice);
    }

    public void determineFlow(String validUserChoice) {
        if (validUserChoice.contentEquals("1") && gameController.isAbleToRestart()) {
            this.restart();
        } else if (validUserChoice.contentEquals("2") && gameController.isAbleToTerminate()) {
            outputComponent.print("게임 종료");
        }
    }

    private void restart() {
        this.gameController = gameControllerFactory.get(scoringFactory);
        this.gameController.start();
        guessUntilCorrect();
    }

}

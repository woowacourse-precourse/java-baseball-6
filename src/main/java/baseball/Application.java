package baseball;

import baseball.controller.DefaultGameControllerFactory;
import baseball.state.DefaultScoringFactory;
import baseball.ui.GameView;
import baseball.ui.input.component.InputComponentForAnswer;
import baseball.ui.input.component.InputComponentForResume;
import baseball.ui.input.validator.InputAnswerValidator;
import baseball.ui.input.validator.InputResumeValidator;
import baseball.ui.output.component.OutputComponentImpl;
import baseball.ui.output.format.ResultFormatStringCreatorImpl;

public class Application {

    public static void main(String[] args) {
        new GameView(new DefaultScoringFactory(), new DefaultGameControllerFactory(),
                new InputComponentForAnswer(new InputAnswerValidator()),
                new InputComponentForResume(new InputResumeValidator()),
                new OutputComponentImpl(),
                new ResultFormatStringCreatorImpl()).start();
    }
}

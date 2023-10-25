package baseball;

import baseball.controller.GameControllerImpl;
import baseball.state.Scoring;
import baseball.ui.GameView;
import baseball.ui.input.component.InputComponentForAnswer;
import baseball.ui.input.component.InputComponentForResume;
import baseball.ui.input.validator.InputAnswerValidator;
import baseball.ui.input.validator.InputResumeValidator;
import baseball.ui.output.component.OutputComponentImpl;
import baseball.ui.output.format.ResultFormatStringCreatorImpl;
import baseball.util.DefaultRandomNumberCreatorByDigit;

public class Application {
    public static void main(String[] args) {
        new GameView(new GameControllerImpl(new Scoring(new DefaultRandomNumberCreatorByDigit().create(3))),
                new InputComponentForAnswer(new InputAnswerValidator()),
                new InputComponentForResume(new InputResumeValidator()),
                new OutputComponentImpl(),
                new ResultFormatStringCreatorImpl()).start();
    }
}

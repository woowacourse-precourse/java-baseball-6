package baseball;

import baseball.controller.GameControllerImpl;
import baseball.controller.RandomNumberCreator;
import baseball.controller.Scoring;
import baseball.ui.GameView;
import baseball.ui.InputAnswerValidator;
import baseball.ui.InputComponentForAnswer;
import baseball.ui.InputComponentForResume;
import baseball.ui.InputResumeValidator;
import baseball.ui.OutputComponentImpl;
import baseball.ui.ResultFormatStringCreatorImpl;

public class Application {
    public static void main(String[] args) {
        new GameView(new GameControllerImpl(new Scoring(RandomNumberCreator.create(3))),
                new InputComponentForAnswer(new InputAnswerValidator()),
                new InputComponentForResume(new InputResumeValidator()),
                new OutputComponentImpl(),
                new ResultFormatStringCreatorImpl()).start();
    }
}

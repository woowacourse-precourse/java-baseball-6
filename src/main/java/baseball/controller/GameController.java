package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.service.NumberMatcher;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private AnswerNumber answerNumber;
    private NumberMatcher numberMatcher;
    private InputView inputView;
    private OutputView outputView;

    public GameController(){
        this.numberMatcher = new NumberMatcher();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

}

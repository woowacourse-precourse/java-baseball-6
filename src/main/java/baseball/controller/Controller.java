package baseball.controller;

import baseball.model.Answer;
import baseball.model.GameScore;
import baseball.util.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Controller {
    private Answer answer;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        inputView.greetingMsg();

        NumberGenerator generator = new NumberGenerator();
        answer = generator.createAnswer();

        boolean flag;

        do {
            inputView.inputGuideMsg();
            List<Integer> input = inputView.inputByConsole();

            GameScore gameScore = answer.calcScore(input);
            gameScore.printResult();

            flag = checkGameDone(gameScore, generator);
        } while (flag);
    }

    private boolean checkGameDone(GameScore gameScore, NumberGenerator generator) {
        if (gameScore.isUserFindAnswer()) {
            outputView.roundEndMsg();
            inputView.askRestartMsg();
            return receiveDecision(generator);
        }

        return true;
    }

    private boolean receiveDecision(NumberGenerator generator) {
        if (inputView.receiveRestartDecisionFromUser()) {
            answer = generator.createAnswer();
            return true;
        }

        return false;
    }
}

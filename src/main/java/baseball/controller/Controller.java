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
    private boolean flag = true;

    public void run() {
        inputView.greetingMsg();
        NumberGenerator generator = new NumberGenerator();
        answer = generator.createAnswer();

        do {
            inputView.inputGuideMsg();
            List<Integer> input = inputView.inputByConsole();
            GameScore gameScore = answer.calcScore(input);
            gameScore.printResult();
            checkGameDone(gameScore, generator);
        } while (flag);
    }

    private void checkGameDone(GameScore gameScore, NumberGenerator generator) {
        if (gameScore.isUserFindAnswer()) {
            outputView.roundEndMsg();
            inputView.askRestartMsg();
            receiveDecision(generator);
        }
    }

    private void receiveDecision(NumberGenerator generator) {
        if (inputView.receiveRestartDecisionFromUser()) {
            answer = generator.createAnswer();
            return;
        }
        flag = false;
    }
}

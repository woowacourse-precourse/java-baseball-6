package baseball.controller;

import baseball.model.Answer;
import baseball.model.GameScore;
import baseball.util.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Controller {
    private static Answer answer;
    private static final NumberGenerator generator = new NumberGenerator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static boolean flag = true;

    public static void run() {
        inputView.greetingMsg();
        answer = generator.createAnswer();

        do {
            inputView.inputGuideMsg();
            List<Integer> input = inputView.inputByConsole();
            GameScore gameScore = answer.calcScore(input);
            outputView.printResult(gameScore);
            checkGameDone(gameScore);
        } while (flag);
    }

    private static void checkGameDone(GameScore gameScore) {
        if (gameScore.isUserFindAnswer()) {
            outputView.roundEndMsg();
            inputView.askRestartMsg();
            receiveDecision();
        }
    }

    private static void receiveDecision() {
        if (inputView.receiveRestartDecisionFromUser()) {
            answer = generator.createAnswer();
            return;
        }
        flag = false;
    }
}

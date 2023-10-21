package baseball.controller;

import baseball.model.Answer;
import baseball.model.GameScore;
import baseball.util.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Controller {
    private static Answer answer;
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void run() {
        NumberGenerator generator = new NumberGenerator();

        inputView.greetingMsg();
        answer = generator.createAnswer();

        while (true) {
            inputView.inputGuideMsg();
            List<Integer> input = inputView.inputByConsole();
            GameScore gameScore = answer.calcScore(input);
            outputView.printResult(gameScore);
            if (gameScore.isUserFindAnswer()) {
                outputView.roundEndMsg();
                inputView.askRestartMsg();
                if (inputView.provideRestartDecisionFromUser()) {
                    answer = generator.createAnswer();
                    continue;
                }
                break;
            }
        }

    }
}

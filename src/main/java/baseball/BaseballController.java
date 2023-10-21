package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    private final BaseballView view;
    private final BaseballModel model;

    private boolean isPlaying = true;

    public BaseballController(BaseballView view, BaseballModel model) {
        this.view = view;
        this.model = model;
    }

    public void startGame() {
        view.outputStartMessage();
    }

    public void playGame() {
        model.chooseRandomNumbers();
        while (isPlaying) {
            view.outputPlayMessage();
            String input = Console.readLine();

            HintResult hintResult = model.getHint(input);
            view.outputHintResultMessage(hintResult);

            if (hintResult.isThreeStrike()) {
                isPlaying = false;
            }
        }
    }
}

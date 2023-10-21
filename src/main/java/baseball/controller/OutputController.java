package baseball.controller;

import baseball.model.Hint;
import baseball.view.OutputView;

public class OutputController {
    private OutputView outputView;

    public OutputController() {
        this.outputView = new OutputView();
    }

    public boolean displayHint(Hint hint) {
        int strikeCount = hint.strike();
        int ballCount = hint.ball();

        return switch (strikeCount) {
            case 3 -> {
                outputView.showStrikeOnlyHint(strikeCount);
                outputView.showGameClearMessage();
                yield true;
            }
            case 0 -> {
                if (ballCount != 0) {
                    outputView.showBallOnlyHint(ballCount);
                    yield false;
                } else {
                    outputView.showNothingHint();
                    yield false;
                }
            }
            default -> {
                if (ballCount != 0) {
                    outputView.showBallAndStrikeHint(ballCount, strikeCount);
                    yield false;
                } else {
                    outputView.showStrikeOnlyHint(strikeCount);
                    yield false;
                }
            }
        };
    }

    public void showIntroMessage() {
        outputView.showIntroMessage();
    }

    public void showGameRestartInputMessage() {
        outputView.showGameRestartInputMessage();
    }

    public void showGameInputMessage() {
        outputView.showGameInputMessage();
    }
}

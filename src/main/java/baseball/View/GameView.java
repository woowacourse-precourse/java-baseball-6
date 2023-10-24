package baseball.View;

import baseball.Domain.BaseballScore;
import camp.nextstep.edu.missionutils.Console;

public class GameView {

    private final OutputView outputView;

    public GameView(OutputView outputView) {
        this.outputView = outputView;
    }

    public void printStart() {
        outputView.printStart();
    }

    public String getNumbers() {
        outputView.printGetNumber();
        return Console.readLine();
    }

    public void printScore(BaseballScore score) {
        outputView.printScore(score);
    }

    public void printEnd() {
        outputView.printEnd();
    }

    public String getAnswer() {
        return Console.readLine();
    }
}

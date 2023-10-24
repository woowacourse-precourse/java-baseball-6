package baseball.View;

import baseball.Domain.BaseballScore;
import camp.nextstep.edu.missionutils.Console;

// TODO: inputview랑 outputview 분리
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
        System.out.println(score);
    }

    public void printEnd() {
        outputView.printEnd();
    }

    public String getAnswer() {
        return Console.readLine();
    }
}

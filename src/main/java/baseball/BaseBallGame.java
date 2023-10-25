package baseball;

import baseball.process.Process;
import baseball.view.View;
import baseball.view.ViewType;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private View view;
    private Process process;
    private int size = 3;

    public BaseBallGame() {
        this.view = new View();
        this.process = new Process(size);
    }

    public void start() {
        view.println(ViewType.START.getStatement());
        while (true) {
            round();
            view.println(ViewType.RESTART.getStatement());
            String isRestart = view.getInput(ViewType.RESTART.getPattern());
            if (isRestart.equals("2")) {
                break;
            }
            process.createRandomBalls(size);
        }
        close();
    }

    private void round() {
        while (true) {
            view.print(ViewType.ROUND.getStatement());
            boolean correctBall = process.isCorrectBall(view.getInput(ViewType.ROUND.getPattern()));
            view.println(process.getCurrentHint().toString());
            if (correctBall) {
                view.println(ViewType.END.getStatement());
                break;
            }
        }
    }

    private void close() {
        Console.close();
    }

}

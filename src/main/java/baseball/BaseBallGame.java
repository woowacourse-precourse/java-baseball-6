package baseball;

import baseball.view.View;
import baseball.view.ViewType;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    private View view;
    private Process process;

    public BaseBallGame() {
        this.view = new View();
        this.process = new Process(3);
    }

    public void start() {
        view.println(ViewType.START.getType());
        while (true) {
            round();
            view.println(ViewType.RESTART.getType());
            String isRestart = view.getInput();
            if (isRestart.equals("2")) {
                break;
            }
        }
        close();
    }

    private void round() {
        while (true) {
            view.print(ViewType.ROUND.getType());
            if (!process.isCorrectBall(view.getInput())) {
                view.println(process.getCurrentHint().toString());
            } else {
                view.println(ViewType.END.getType());
                break;
            }
        }
    }

    private void close() {
        Console.close();
    }

}

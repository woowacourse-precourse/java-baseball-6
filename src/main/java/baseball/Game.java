package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final int FINISH = 3;

    private Computer computer;
    private User user;
    private Result result;

    public Game() {
        computer = new Computer();
        user = new User();
        result = new Result();
    }

    public void start() {
        View.start();
        do {
            play();
        } while (restart());
    }

    private boolean restart() {
        View.restart();
        int result = Integer.parseInt(Console.readLine());
        if (result == 1) {
            return true;
        }
        return false;
    }

    private void play() {
        computer.createNumbers();
        do {
            result.init();

            View.input();
            user.inputNumbers();
            result.calc(computer.getNumbers(), user.getNumbers());

            View.result(result.getStrike(), result.getBall());
        } while (!isFinish());
        View.end();
    }

    private boolean isFinish() {
        if (result.getStrike() == FINISH) {
            return true;
        }
        return false;
    }
}

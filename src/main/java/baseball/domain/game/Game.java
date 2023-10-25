package baseball.domain.game;

import baseball.domain.ball.Balls;
import baseball.domain.computer.Computer;
import baseball.domain.picker.BallPicker;
import baseball.domain.result.Result;
import baseball.domain.user.User;

public class Game {
    private final BallPicker ballPicker;
    private final GameOperator gameOperator;

    public Game(BallPicker ballPicker, GameOperator gameOperator) {
        this.ballPicker = ballPicker;
        this.gameOperator = gameOperator;
    }

    public void play() {
        do {
            pickComputer();

        } while (wantsToContinue());
    }

    private void pickComputer() {
        Computer computer = Computer.generate(ballPicker);

        boolean isCompleted = false;

        while (!isCompleted) {
            isCompleted = progress(computer);
        }
    }

    private boolean progress(Computer computer) {
        Balls balls = batting();
        User user = new User(balls);

        Result result = user.compare(computer);
        gameOperator.round(result);

        return result.isComplete();
    }

    private Balls batting() {
        return gameOperator.batting();
    }

    public boolean wantsToContinue() {
        return gameOperator.isContinue();
    }
}

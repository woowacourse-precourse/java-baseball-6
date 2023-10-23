package baseball;

import baseball.entity.Ball;
import baseball.entity.GameResult;
import baseball.entity.Strike;

public class Application {
    public static void main(String[] args) {
        Strike strike = new Strike();
        Ball ball = new Ball();
        GameResult gameResult = new GameResult(strike, ball, false);
        Model model = new Model(gameResult);
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.startGame();
    }
}

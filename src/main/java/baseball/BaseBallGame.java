package baseball;

import baseball.view.View;
import baseball.view.format.Format;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class BaseBallGame {

    private Ball ball;
    private View view;
    private Map<String, Format> formatMap;

    public BaseBallGame() {
        this.ball = new Ball();
        this.view = new View();
        loadFormats();
    }

    private void loadFormats() {
        formatMap = new HashMap<>();

    }

    public void start() {
        while (true) {
            ball.createRandomBall(3);
        }
        // close();
    }

    public void round() {
        while (true) {
           
        }
    }

    private void close() {
        Console.close();
    }

}

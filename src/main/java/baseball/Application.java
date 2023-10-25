package baseball;

import baseball.hint.Ball;
import baseball.hint.Strike;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        Output output = new Output();
        Strike strike = new Strike();
        Ball ball = new Ball();
        Play play = new Play();

        output.printStartingMessage();
        play.playBaseball(input, output, strike, ball);
    }
}

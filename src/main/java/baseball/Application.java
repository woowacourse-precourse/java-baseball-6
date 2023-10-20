package baseball;

import java.util.List;

public class Application {

    private static final int LIST_LEN = 3;

    public static void main(String[] args) {
        OutputView.showOpening();
        boolean running = true;

        while (running) {
            run();
            OutputView.showClosing();
            running = InputView.askOneOrTwo();
        }
    }

    private static void run() {
        List<Integer> answer = Generator.generateAnswer(LIST_LEN);
        boolean playing = true;

        while (playing) {
            String input = InputView.askNumber(LIST_LEN);
            List<Integer> inputList = Generator.generateInputList(input);

            int strike = Game.countStrike(inputList, answer);
            int ball = Game.countBall(inputList, answer);

            OutputView.showResult(strike, ball);

            playing = Game.isNotOver(strike);
        }
    }
}

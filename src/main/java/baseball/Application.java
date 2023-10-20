package baseball;

import baseball.controller.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private static final int LIST_LEN = 3;
    private static final int ONE_OR_TWO_LEN = 1;

    public static void main(String[] args) {
        OutputView.showOpening();
        boolean running = true;

        while (running) {
            run();

            OutputView.showClosing();
            InputView.askOneOrTwo();

            String input = Console.readLine();
            Validation.validateInputLength(input, ONE_OR_TWO_LEN);
            int inputNum = input.charAt(0) - '0';
            Validation.validateOneOrTwo(inputNum);

            running = (inputNum == 1);
        }
    }

    private static void run() {
        List<Integer> answer = Generator.generateAnswer(LIST_LEN);
        boolean playing = true;

        while (playing) {
            InputView.askNumber();

            String input = Console.readLine();
            Validation.validateInputLength(input, LIST_LEN);

            List<Integer> inputList = Generator.generateInputList(input);

            int strike = Game.countStrike(inputList, answer);
            int ball = Game.countBall(inputList, answer);

            OutputView.showResult(strike, ball);

            playing = Game.isNotOver(strike);
        }
    }
}

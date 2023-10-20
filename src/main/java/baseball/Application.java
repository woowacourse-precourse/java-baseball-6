package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.opening();
        boolean flag = true;

        while (flag) {
            game();
            OutputView.closing();
            flag = InputView.inputOneOrTwo();
        }
    }

    private static void game() {
        List<Integer> answer = Generator.createAnswer();
        boolean gameFlag = true;

        while (gameFlag) {
            List<Integer> input = InputView.inputList();

            int strike = Calculator.countStrike(input, answer);
            int ball = Calculator.countBall(input, answer);

            OutputView.showResult(strike, ball);

            gameFlag = Calculator.isNotOver(strike);
        }
    }
}

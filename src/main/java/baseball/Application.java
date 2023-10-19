package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Printing.opening();
        boolean flag = true;

        while (flag) {
            game();

            flag = UserInput.inputOneOrTwo();
        }
    }

    private static void game() {
        List<Integer> answer = Generator.createAnswer();
        boolean gameFlag = true;

        while (gameFlag) {
            List<Integer> input = UserInput.inputList();

            int strike = Calculator.countStrike(input, answer);
            int ball = Calculator.countBall(input, answer);

            Printing.showResult(strike, ball);

            if (strike == 3) {
                gameFlag = false;
            }
        }
    }
}

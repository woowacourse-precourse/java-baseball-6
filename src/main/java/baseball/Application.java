package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        View.opening();
        boolean flag = true;

        while (flag) {
            game();
            View.closing();
            flag = UserInput.inputOneOrTwo();
        }
    }

    private static void game() {
        List<Integer> answer = Generator.createAnswer();
        boolean gameFlag = true;

        while (gameFlag) {
            View.inputting();
            List<Integer> input = UserInput.inputList();

            int strike = Calculator.countStrike(input, answer);
            int ball = Calculator.countBall(input, answer);

            View.showResult(strike, ball);

            gameFlag = Calculator.isNotOver(strike);
        }
    }
}

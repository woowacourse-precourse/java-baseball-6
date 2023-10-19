package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Printing.opening();
        boolean flag = true;

        while (flag) {
            List<Integer> answer = Generator.createAnswer();
            boolean gameFlag = true;

            while (gameFlag) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> input = UserInput.inputList();

                int strike = Calculator.countStrike(input, answer);
                int ball = Calculator.countBall(input, answer);

                Printing.showResult(strike, ball);

                if (strike == 3) {
                    gameFlag = false;
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            Printing.closing();
            flag = UserInput.inputOneOrTwo();
        }
    }
}

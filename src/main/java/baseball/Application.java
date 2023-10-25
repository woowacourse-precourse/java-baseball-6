package baseball;

import baseball.controller.ScoreJudgement;
import baseball.model.Generator;
import baseball.model.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static boolean is3Strike = false;

    public static void main(String[] args) {

        OutputView.startGame();
        int computerNumber = Generator.generateComputerNumber();

        while (true) {
            if (is3Strike) {
                String optionString = InputView.selectOption();

                int optionNumber = Validation.getOptionNumber(optionString);
                if (optionNumber == 1) {
                    computerNumber = Generator.generateComputerNumber();
                    is3Strike = false;
                } else {
                    break;
                }
            }
            int userNumber = Generator.generateUserNumber();
            printHint(computerNumber, userNumber);
        }
    }

    public static void printHint(int computerNumber, int userNumber) {

        if (computerNumber - userNumber == 0) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            is3Strike = true;
            return;
        }

        int strike = ScoreJudgement.countStrike(computerNumber, userNumber);
        int ball = ScoreJudgement.countSameNumber(computerNumber, userNumber) - strike;

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike == 0) {
            System.out.printf("%d볼\n", ball);
            return;
        }

        if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }

        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }

}

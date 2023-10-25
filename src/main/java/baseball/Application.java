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
        System.out.println("computerNumber = " + computerNumber);

        while (true) {
            // 게임에서 3스트라이크를 했을 때 수행
            if (is3Strike) {
                String optionString = InputView.selectOption();

                int optionNumber = Validation.getOptionNumber(optionString);
                if (optionNumber == 1) {
                    computerNumber = Generator.generateComputerNumber();
                    is3Strike = false;
                    System.out.println("computerNumber = " + computerNumber);
                } else {
                    // getOptionNumber로 이미 검증을 거친 상태이기 때문에 넘어올 수 있는 수는 1과 2 둘 중 하나이다.
                    break;
                }
            }
            // 게임에서 아직 3스트라이크를 달성하지 못한 경우
            int userNumber = Generator.generateUserNumber();
            printHint(computerNumber,userNumber);
        }
    }

    /**
     * 스트라이크의 개수와 볼의 개수가 같으면 스트라이크의 개수를 출력하고, 볼은 0으로 처리해야 한다.
     * 3스트라이크가 나오면 게임이 종료된다.
     */
    private static void printHint(int computerNumber, int userNumber) {

        if (computerNumber - userNumber == 0) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            is3Strike = true;
            return;
        }

        int strike = ScoreJudgement.countStrike(computerNumber, userNumber);
        // 컴퓨터와 유저의 숫자 중 같은 숫자가 몇 개인지 알아낸 뒤
        // 스트라이크의 개수를 빼면 볼의 개수를 구할 수 있다.
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

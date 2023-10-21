package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class Game implements Numbers {

    public void startGame() {
        OutputView.printStartMsg(); // 숫자 야구 게임을 시작합니다.
    }

    public void proceedGame() {
        ComputerNumbers computerNumbers = new ComputerNumbers();
        boolean ongoing = true;

        while(ongoing) {
            InputView.printInputMsg(); // 숫자를 입력해주세요 :

            ClientNumbers clientNumbers = InputView.makeClientNumbers();
            Info info = clientNumbers.compareWithComputerNumbers(computerNumbers);

            System.out.println("--------- computerNumbers ---------");
            System.out.println(computerNumbers.hashCode());
            System.out.println(computerNumbers.getNumbers().size());
            System.out.println("--------- clientNumbers ---------");
            System.out.println(clientNumbers.hashCode());
            System.out.println(clientNumbers.getNumbers().size());

            int ball = info.ball;
            int strike = info.strike;
            boolean ongoing2 = info.ongoing;
            System.out.println(ball + " " + strike + " " + ongoing2);

            if (ball > 0 && strike > 0) {
                OutputView.printBallAndStrikeMsg(ball, strike); // ?볼 ?스트라이크
            } else if (ball > 0) {
                OutputView.printBallMsg(ball); // ?볼
            } else if (strike > 0) {
                OutputView.printStrikeMsg(strike); // ?스트라이크
            } else if (ball == 0 && strike == 0) {
                OutputView.printNothingMsg(); // 낫싱
            }

            if (strike == 3) {
                ongoing = info.ongoing;
                OutputView.printSuccessMsg(); // 3개의 숫자를 모두 맞히셨습니다! 게임 종료
            }
        }
    }

    public void restartOrExitGame() {
        boolean oneMore = true;

        while(oneMore) {
            OutputView.printRestartOrExitMsg(); // 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
            int inputInt = Integer.parseInt(Console.readLine());
            if(inputInt == 1) {
                proceedGame();
            } else {
                oneMore = false;
                OutputView.printExitMsg();
            }
        }
    }
}

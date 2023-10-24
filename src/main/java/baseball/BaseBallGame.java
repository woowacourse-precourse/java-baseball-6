package baseball;

import baseball.constant.ServiceMessage;
import baseball.counter.Ball;
import baseball.counter.Strike;
import baseball.hint.Printer;
import baseball.hint.TotalMessage;
import baseball.input.EndValidator;
import baseball.input.Validator;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    public BaseBallGame() {
        System.out.print(ServiceMessage.START.serviceMessage);
    }

    public void startGame() {
        // 서로 다른 3자리 수를 컴퓨터가 지정한다.
        InitNumber initNumber = new InitNumber();
        String answer = initNumber.getInitNumber();

        System.out.println("answer = " + answer);

        while (true) {
            System.out.print(ServiceMessage.INPUT.serviceMessage);

            String line = "";
            line = Console.readLine();

            if (!Validator.isValid(line)) {
                throw new IllegalArgumentException("입력값이 잘못됐습니다. 1-9까지의 서로 다른 3자리 수를 입력해 주세요.");
            }

            int ballCount = Ball.countBalls(answer, line);
            int strikeCount = Strike.countStrike(answer, line);

            String message = TotalMessage.sumMessage(ballCount, strikeCount);
            Printer.print(message);
            if (Printer.isFinished(message)) {
                System.out.print(ServiceMessage.SUCCESS.serviceMessage);
                System.out.print(ServiceMessage.RETRY.serviceMessage);

                line = Console.readLine();

                EndValidator.isValid(line);
                if (Integer.parseInt(line) == 2) {
                    Console.close();
                    break;
                }
                startGame();
                Console.close();
                break;
            }
        }
    }
}

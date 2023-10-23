package baseball;

import baseball.constant.ServiceMessage;
import baseball.constant.StatusMessage;
import baseball.counter.Ball;
import baseball.counter.Strike;
import baseball.hint.Message;
import baseball.hint.Printer;
import baseball.input.Validator;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    public void startGame() {
        // 서로 다른 3자리 수를 컴퓨터가 지정한다.
        InitNumber initNumber = new InitNumber();
        String answer = initNumber.getInitNumber();

        System.out.println("answer = " + answer);

        while (true) {
            System.out.print(ServiceMessage.INPUT.serviceMessage + " ");

            String line = "";
            line = Console.readLine();
            // 예외 처리 모듈화 필요
            if (!Validator.isValid(line)) { // 예: 빈 문자열 또는 null을 부적절한 입력으로 처리
                throw new IllegalArgumentException("입력값이 잘못됐습니다.");
            }

            int ballCount = Ball.countBalls(answer, line);
            int strikeCount = Strike.countStrike(answer, line);

            String message = Message.getMessage(ballCount, StatusMessage.BALL) + " " + Message.getMessage(strikeCount,
                    StatusMessage.STRIKE);
            if (Printer.isFinished(message)) {
                Printer.print(message);
                System.out.print(ServiceMessage.SUCCESS.serviceMessage);
                System.out.print(ServiceMessage.RETRY.serviceMessage);
                // 입력값 예외 처리 필요
                if (Integer.parseInt(Console.readLine()) == 2) {
                    return;
                }
                startGame();
            }

            Printer.print(message);
        }
    }
}

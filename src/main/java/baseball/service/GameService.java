package baseball.service;

import baseball.Enum.ResultCase;
import baseball.Exception.Exception;
import baseball.domain.Computer;
import baseball.domain.Result;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

    public static void run() {
        Computer computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (game(computer.getGoal())) {
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static Boolean game(int[] computer) {
        System.out.print("숫자를 입력 해 주세요 : ");
        char[] userGuess = Console.readLine().toCharArray();
        Exception.checkException(userGuess);

        Result result = new Result(computer, userGuess);
        checkResult(result);

        return result.getStrike() == 3;
    }

    private static void printResult(ResultCase resultCase, int ball, int strike) {
        switch (resultCase) {
            case NOTHING -> System.out.println("낫싱");
            case BALL -> System.out.println(ball + "볼");
            case STRIKE -> System.out.println(strike + "스트라이크");
            case BALL_AND_STRIKE -> System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }
    }

    private static void checkResult(Result result) {
        ResultCase resultCase = ResultCase.NOTHING;
        if (result.getBall() != 0) {
            resultCase = resultCase.next(1);
        }
        if (result.getStrike() != 0) {
            resultCase = resultCase.next(2);
        }
        printResult(resultCase, result.getBall(), result.getStrike());
    }
}

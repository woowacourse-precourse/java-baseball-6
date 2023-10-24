package baseball.util;

import static baseball.view.InputView.checkInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class RestartCalculator {

    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int RESTART_NUMBER_LENGTH = 1;
    private static final String RESTART_NUM = "1";
    private static final String FINISH_NUM = "2";

    // 재시작할지 물어보는 함수
    public static boolean isRestart() {

        System.out.println(RESTART_MESSAGE);

        try {

            String restartInput = Console.readLine();

            // 유저가 제시한 restartInput이 한자리의 숫자인지 판단(InputView에 있는 예외 판단 재사용)
            checkInput(restartInput, RESTART_NUMBER_LENGTH);

            // 1일 때 재시작, 2일 때 종료, 이 외의 숫자일 때 exception
            return checkRestartNumber(restartInput);

        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException(e.getMessage());

        }

    }

    // 1일 때 재시작, 2일 때 종료, 이 외의 숫자일 때 exception
    private static boolean checkRestartNumber(String restartInput) {

        if (Objects.equals(restartInput, RESTART_NUM)) {

            return true;

        } else if (Objects.equals(restartInput, FINISH_NUM)) {

            return false;

        }

        throw new IllegalArgumentException("적절한 숫자가 아닙니다!");


    }


}

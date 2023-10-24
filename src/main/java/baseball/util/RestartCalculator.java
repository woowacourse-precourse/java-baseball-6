package baseball.util;

import static baseball.view.InputView.checkInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class RestartCalculator {

    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int RESTART_NUMBER_LENGTH = 1;


    public static boolean isRestart() {

        System.out.println(RESTART_MESSAGE);

        try {

            String restartInput = Console.readLine();

            checkInput(restartInput, RESTART_NUMBER_LENGTH);

            return checkRestartNumber(restartInput);

        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException(e.getMessage());

        }

    }

    private static boolean checkRestartNumber(String restartInput) {

        if (Objects.equals(restartInput, "1")) {

            return true;

        } else if (Objects.equals(restartInput, "2")) {

            return false;

        } else {

            throw new IllegalArgumentException("적절한 숫자가 아닙니다!");

        }


    }


}

package baseball.verification;

import baseball.constants.NumberConstants;
import camp.nextstep.edu.missionutils.Console;

public class RestartVerification {
    public static boolean askForRestart() {

        NumberConstants numberConstants = new NumberConstants();

        while (true) {
            try {
                int whatToDo = Integer.parseInt(Console.readLine());
                if (numberConstants.wantQuit(whatToDo)) {
                    return false;
                }
                if (numberConstants.wantRestart(whatToDo)) {
                    return true;
                }
                System.out.println("잘못된 입력입니다. 1(재시작) 또는 2(종료)를 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자(1 or 2)를 입력해주세요.");
            }
        }
    }
}

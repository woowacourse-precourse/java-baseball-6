package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class User {
    private static final String INPUT_NUMBER_MENT = "숫자를 입력해주세요 : ";

    public User() {
    }

    public String inputNum() {
        System.out.print(INPUT_NUMBER_MENT);
        return readLine();
    }

    public Boolean continueGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String flag = readLine();
        if (flag.equals("1")) {
            return TRUE;
        }
        return FALSE;
    }
}

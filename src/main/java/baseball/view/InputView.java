package baseball.view;

import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String EXIT_COMMAND = "2";
    private static final String RESTART_COMMAND = "1";

    public static Numbers readUserNumbers() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        return new Numbers(input);
    }

    public static boolean readContinueOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals(EXIT_COMMAND)) {
            return false;
        } else if (input.equals(RESTART_COMMAND)) {
            return true;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}

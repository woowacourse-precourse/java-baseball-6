package baseball.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 입력 관리
 * @see camp.nextstep.edu.missionutils.Console
 */
public class InputView {
    /**
     * 숫자 입력
     *
     * @return String 입력한 숫자
     */
    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    /**
     * 재시작 입력
     *
     * @return String 입력한 재시작 여부
     */
    public static String getRestartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}

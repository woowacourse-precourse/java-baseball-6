package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Restart {
    private static final String RESTART_NUMBER = "1";

    private static final String END_NUMBER = "2";

    public String inputRestartNumber() {
        return Console.readLine();
    }

    public boolean checkRestartNumber(String number) {
        if (number.equals(RESTART_NUMBER)) {
            return true;
        } else if (number.equals(END_NUMBER)) {
            return false;
        } else throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }
}

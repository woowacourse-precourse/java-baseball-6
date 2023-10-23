package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private final static String OUT_OF_RANGE = "숫자 야구는 1~9까지 수만 취급 합니다.";


    public void strikeCheck() {
        System.out.println("스트라이크 확인 합시다!!");
    }

    public String inputNumber() {
        String number = Console.readLine();
        if (!numberCheck(number)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
        return number;
    }

    private boolean numberCheck(String input) {
        return input != null && input.length() == 3 && input.matches("^[1-9]*$");
    }
}

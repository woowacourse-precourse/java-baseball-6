package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String setPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static int setRetryNumber() {
        String inputRetryNumber = Console.readLine();
        if (!inputRetryNumber.equals("1") && !inputRetryNumber.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
        return Integer.parseInt(inputRetryNumber);
    }
}

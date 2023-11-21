package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void readUserNum() {
        try {
            String userNum = Console.readLine();

            int userNumber = convertStringToInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int convertStringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다. 재입력 하세요.");
        }
    }
}


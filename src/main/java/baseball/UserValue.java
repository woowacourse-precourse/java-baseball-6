package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserValue {
    public static int getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Integer.parseInt(Console.readLine());
    }
}

package others;

import camp.nextstep.edu.missionutils.Console;

public class Others {
    public static String getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine().trim().replaceAll(" ", "");
    }
}
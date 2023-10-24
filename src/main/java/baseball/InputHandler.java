package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String getPlayInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return input;
    }
}

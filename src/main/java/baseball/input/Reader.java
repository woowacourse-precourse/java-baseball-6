package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
    public static String read() {
        String line = Console.readLine();

        if (!Validator.isValid(line)) {
            throw new IllegalArgumentException("입력값이 잘못됐습니다. 1-9까지의 서로 다른 3자리 수를 입력해 주세요.");
        }

        return line;
    }
}

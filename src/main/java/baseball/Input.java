package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {

    public String getGameExitOrRestartInput() {
        String input = Console.readLine();
        if (!List.of("1", "2").contains(input)) {
            throw new IllegalArgumentException("1 또는 2를 입력해야합니다.");
        }
        return input;
    }

    public String getNumberInput() {
        String input = Console.readLine();
        // 입력을 제대로 못받을 경우 예외 던진다. ( 현재는 무조건 3글자만 )
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.(입력:3자리 숫자)");
        }
        return input;
    }
}

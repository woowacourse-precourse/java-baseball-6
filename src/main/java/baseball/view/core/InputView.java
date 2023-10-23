package baseball.view.core;

import camp.nextstep.edu.missionutils.Console;

public final class InputView extends ConsoleWriter {
    public String readUserInput() {
        this.print("숫자를 입력해주세요 : ");
        final var input = Console.readLine();
        return input;
    }

}

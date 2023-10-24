package baseball.view.core;

import camp.nextstep.edu.missionutils.Console;

public final class InputView extends ConsoleWriter {
    public String readUserInput() {
        this.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public int readRetryCommand() {
        this.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final var input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("재시작 명령어는 숫자여야 합니다.");
        }
    }
}

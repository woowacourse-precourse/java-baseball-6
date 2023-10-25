package baseball.view;

import baseball.handler.OutputHandler;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void printGameResult(String result) {
        System.out.println(result);
    }
}

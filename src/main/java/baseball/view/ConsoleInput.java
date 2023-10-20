package baseball.view;

import baseball.handler.InputHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInput implements InputHandler {

    @Override
    public String inputValue() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    @Override
    public int inputGameResult() {
        return 0;
    }
}

package baseball.view;

import baseball.handler.InputHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInput implements InputHandler {

    @Override
    public String inputUserValue() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    @Override
    public int inputGameResult() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(readLine());
    }
}

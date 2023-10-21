package baseball.handler;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getNumbers(){
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    public String getCommand(){
        System.out.println(RESTART_MESSAGE);
        String command = Console.readLine();
        return command;
    }
}

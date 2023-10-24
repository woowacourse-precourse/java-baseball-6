package view;

import camp.nextstep.edu.missionutils.Console;
import Exception.CommandException;
import Exception.NumberException;

public class InputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public static String inputPlayerNumbers() {
        System.out.print(INPUT_MESSAGE);
        String numbers = Console.readLine();
        NumberException.numberException(numbers);
        return numbers;
    }

    public static boolean inputRestart() {
        boolean isRestart = false;
        System.out.printf(RESTART_MESSAGE, RESTART, EXIT);
        String flag = Console.readLine();
        CommandException.commandException(flag);
        if (flag.equals("1")) {
            isRestart = true;
        }
        return isRestart;
    }


}

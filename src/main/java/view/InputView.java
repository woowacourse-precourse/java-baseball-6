package view;

import camp.nextstep.edu.missionutils.Console;
import domain.NumberException;

public class InputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_FLAG = "1";
    private static final String END_FLAG = "2";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";

    public static String inputPlayerNumbers() {
        System.out.print(INPUT_MESSAGE);
        String numbers = Console.readLine();
        NumberException.numberException(numbers);
        return numbers;
    }

    public static boolean inputRestart() {
        boolean isRestart = false;
        System.out.printf(RESTART_MESSAGE, RESTART_FLAG, END_FLAG);
        String flag = Console.readLine();
        if (flag.equals(RESTART_FLAG) && flag.equals(END_FLAG)) {
            throw new IllegalArgumentException("\nError : " + RESTART_FLAG + "이나 " + END_FLAG + "를 입력해 주세요.");
        }
        if (flag.equals(RESTART_FLAG)) {
            isRestart = true;
        }
        return isRestart;
    }


}

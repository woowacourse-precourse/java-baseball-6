package baseball.view;

import baseball.util.Util;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static boolean askExit() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        Util.validateExitCode(userInput);

        if(userInput.equals("2")) {
            return true;
        }

        return false;
    }

    public static String askUserNumbers() {

        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}

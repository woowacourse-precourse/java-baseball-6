package baseball.userInterface;

import camp.nextstep.edu.missionutils.Console;

/*
 입력을 담당하는 클래스
 */
public class InputViewer {
    public static String requestUserAnswer() {
        MessageViewer.printInputRequestMsg();
        return Console.readLine();
    }

    public static String requestUserRestartFactor() {
        MessageViewer.printRestartInputRequestMsg();
        return Console.readLine();
    }
}

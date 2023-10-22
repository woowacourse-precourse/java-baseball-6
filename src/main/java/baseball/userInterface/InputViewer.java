package baseball.userInterface;

import camp.nextstep.edu.missionutils.Console;

import static baseball.userInterface.MessageViewer.printInputRequestMsg;
import static baseball.userInterface.MessageViewer.printRestartInputRequestMsg;

/*
 입력을 담당하는 클래스
 */
public class InputViewer {
    public static String requestUserAnswer(){
        printInputRequestMsg();
        return Console.readLine();
    }

    public static String requestUserRestartFactor(){
        printRestartInputRequestMsg();
        return Console.readLine();
    }
}

package view;

import camp.nextstep.edu.missionutils.Console;
import constants.MessageConstants;

public class Input {

    // Player: 3자리 숫자 입력
    public static String readInput(){
        System.out.println(MessageConstants.INPUT_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    // Player: 재시작(1) or 종료(2) 입력
    public static String readOption(){
        System.out.println(MessageConstants.RESTART_OR_FINISH_MESSAGE);
        String input = Console.readLine();
        return input;
    }
}

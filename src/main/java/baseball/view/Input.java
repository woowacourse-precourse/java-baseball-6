package baseball.view;

import baseball.message.ConsoleMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import baseball.ErrorManage;

public class Input {
    private static final ErrorManage errorManage = new ErrorManage();
    public static List<Integer> inputUserNumber(){
        System.out.print(ConsoleMessage.INPUT_NUMBER.getMessage());
        String userInput = Console.readLine();

        errorManage.checkIsNumber(userInput);
        errorManage.checkNumberLength(userInput);

        String[] userNumberString = userInput.split("");

        List<Integer> userNumberList = new ArrayList<>();

        for(String num : userNumberString){
            userNumberList.add(Integer.parseInt(num));
        }

        errorManage.checkDuplicate(userNumberList);
        errorManage.checkNumberRange(userNumberList);

        return userNumberList;
    }

    public static int inputGameFlag(){
        int gameFlag = Integer.parseInt(Console.readLine());
        ErrorManage.wrongGameFlag(gameFlag);

        return gameFlag;
    }
}

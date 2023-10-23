package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    static private String getUserInput(){
        return Console.readLine();
    }

    static public String getUserInputNumber(){
        UserOutput.consoleOutUserInput();
        return getUserInput();
    }

    static public String getUserInputGameResume(){
        UserOutput.consoleOutGameResume();
        return getUserInput();
    }
}

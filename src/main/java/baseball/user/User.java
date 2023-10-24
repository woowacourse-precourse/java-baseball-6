package baseball.user;

import baseball.io.Converter;
import baseball.locales.GameScripts;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {

    public List<Integer> inputNumber(int length) {
        System.out.print(GameScripts.INPUT_NUMBER);
        String userInput = Console.readLine();
        return Converter.convertToUniqueIntList(userInput, length);
    }

    public boolean checkRestart() {
        System.out.println(GameScripts.RESTART_MENU);
        String userInput = Console.readLine();
        int menuRestart = 1;
        int menuEnd = 2;
        int select = Converter.convertIntWithRange(userInput, menuRestart, menuEnd);

        return select == menuRestart;
    }


}

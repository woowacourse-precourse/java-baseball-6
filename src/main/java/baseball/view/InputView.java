package baseball.view;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import static baseball.exception.InputException.*;

public class InputView {

    public static List<Integer> inputPlayerNumbers(){
        String input = Console.readLine();

        notNumericException(input);
        lengthException(input);

        List<Integer> playerNumbers = new ArrayList<>();
        for(String num : input.split("")) {
            int number = Integer.parseInt(num);
            playerNumbers.add(number);
        }
        duplicateException(playerNumbers);
        outOfRangeException(playerNumbers);

        return playerNumbers;
    }


    public static boolean inputRestartDecision(){
        String input = Console.readLine();

        notNumericException(input);
        gameDecisionException(input);

        if(input.equals("1")) { return true; }
        return false;
    }
}

package baseball.view;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import static baseball.exception.InputException.*;

public class InputView {
    private static List<Integer> playerNumbers;

    public static List<Integer> inputPlayerNumbers(){

        OutputView.playerInputPrint();
        String input = Console.readLine();

        notNumericException(input);
        lenException(input);

        playerNumbers = new ArrayList<>();
        for(String num : input.split("")) {
            int number = Integer.parseInt(num);
            playerNumbers.add(number);
        }
        duplicateException(playerNumbers);
        outOfRangeException(playerNumbers);

        return playerNumbers;
    }
}

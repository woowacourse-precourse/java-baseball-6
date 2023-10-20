package baseball.view;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import static baseball.exception.InputException.*;

public class InputView {
    static List<String> numbers;
    public InputView() {
        this.numbers = inputPlayerNumbers();
    }
    public static List<String> inputPlayerNumbers(){
        List<String> playerNumbers = new ArrayList<>();
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        notNumericException(input);
        lenException(input);

        for(String number : input.split(""))
            playerNumbers.add(number);

        duplicateException(playerNumbers);
        outOfRangeException(playerNumbers);

        return playerNumbers;
    }
}

package baseball.view;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import static baseball.exception.InputException.*;

public class InputView {
    static List<Integer> numbers;
    public InputView() {
        this.numbers = inputPlayerNumbers();
    }
    public static List<Integer> inputPlayerNumbers(){

        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        notNumericException(input);
        lenException(input);

        List<Integer> playerNumbers = new ArrayList<>();
        for(String num : input.split("")) {
            int number = Integer.parseInt(num);
            playerNumbers.add(number);
        }
        duplicateException(playerNumbers);
        outOfRangeException(playerNumbers);

        return playerNumbers;
    }
}

package baseball.print;

import static baseball.print.OutputMessage.printEnterNumber;
import static baseball.validation.Validation.validationCheck;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.stream.Collectors;

public class InputMessage {
    public static List<Integer> inputMessageNumber() {
        printEnterNumber();
        String stringInputMessage = readLine();
        List<Integer> integerInputMessage = stringInputMessage.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());

        validationCheck(integerInputMessage);

        return integerInputMessage;
    }
}

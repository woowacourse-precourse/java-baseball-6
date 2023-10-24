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

    public static Integer getGameStatusInput() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String endInputMessage = readLine();

        return (endInputMessage != null) ? Integer.valueOf(endInputMessage) : 0;
    }
}

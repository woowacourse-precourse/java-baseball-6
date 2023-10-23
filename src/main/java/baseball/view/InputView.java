package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String NUMBER_SPLIT_DELIMITER = "";
    private static final String READ_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String READ_COMMAND_MESSAGE_FORMAT = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.%n";

    public static List<String> readPlayerNumbers() {
        System.out.print(READ_NUMBER_MESSAGE);

        String playerNumbers = Console.readLine().trim();

        return Arrays.stream(playerNumbers.split(NUMBER_SPLIT_DELIMITER)).toList();
    }

    public static String readPlayerCommand(int restartValue, int endValue) {
        System.out.format(READ_COMMAND_MESSAGE_FORMAT, restartValue, endValue);

        return Console.readLine().trim();
    }
}

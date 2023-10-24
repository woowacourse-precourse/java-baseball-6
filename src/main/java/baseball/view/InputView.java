package baseball.view;

import baseball.utils.GameStatusCommand;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자로부터 입력 받는 역할을 수행한다.
 */
public class InputView {

    private static final String ERROR_MESSAGE_INTEGER_ONLY = "[ERROR] 정수만 입력 가능합니다.";

    private InputView() {
    }

    /**
     * 플레이어의 수를 입력 받는다.
     */
    public static List<Integer> readNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            return Arrays.stream(Console.readLine()
                            .split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INTEGER_ONLY);
        }
    }

    /**
     * 게임의 재시작/종료 여부에 대한 숫자를 입력 받는다.
     */
    public static int readNumberOfGameStatusCommand() {
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.%n",
                GameStatusCommand.RESTART.getNumber(),
                GameStatusCommand.QUIT.getNumber());
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INTEGER_ONLY);
        }
    }
}

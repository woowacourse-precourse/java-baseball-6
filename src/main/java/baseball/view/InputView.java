package baseball.view;

import baseball.domain.GameNumber;
import baseball.domain.RetryCommand;
import baseball.util.Convertor;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.util.ErrorMessage.NUMERIC_ERROR;

public class InputView {

    private static final String USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public GameNumber getUserNumber() {
        System.out.print(USER_NUMBER_MESSAGE);
        String input = Console.readLine();
        try {
            List<Integer> inputNumber = Convertor.convertStringToList(input);
            return new GameNumber(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ERROR);
        }
    }

    public RetryCommand getRetryCommand() {
        System.out.println(RETRY_MESSAGE);
        String input = Console.readLine();
        return Convertor.findByInput(input);
    }
}

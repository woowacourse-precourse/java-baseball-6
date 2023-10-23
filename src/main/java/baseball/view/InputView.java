package baseball.view;

import baseball.domain.RetryCommand;
import baseball.domain.number.UserNumber;
import baseball.util.TypeConvertor;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private static final String USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final TypeConvertor typeConvertor;

    public InputView(TypeConvertor typeConvertor) {
        this.typeConvertor = typeConvertor;
    }

    public UserNumber getUserNumber() {
        System.out.print(USER_NUMBER_MESSAGE);
        String input = Console.readLine();
        List<Integer> inputNumber = typeConvertor.convertStringToList(input);
        return new UserNumber(inputNumber);
    }

    public RetryCommand getRetryCommand() {
        System.out.println(RETRY_MESSAGE);
        String input = Console.readLine();
        return typeConvertor.findByInput(input);
    }
}

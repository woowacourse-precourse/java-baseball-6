package baseball.view;

import baseball.domain.Balls;
import baseball.util.InputConvertor;
import baseball.util.InputValidator;
import baseball.domain.Retry;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String BALL_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RETRY_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static InputView instance;

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public Balls scanBalls() {
        System.out.println(BALL_NUMBER_INPUT_MESSAGE);
        String rawBalls = Console.readLine();
        InputValidator.validateBalls(rawBalls);
        return InputConvertor.convertBalls(rawBalls);
    }

    public Retry scanRetry() {
        System.out.println(RETRY_INPUT_MESSAGE);
        String rawRetry = Console.readLine();
        return Retry.from(rawRetry);
    }
}

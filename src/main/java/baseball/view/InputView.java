package baseball.view;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.util.InputConvertor;
import baseball.util.InputValidator;
import baseball.domain.Retry;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.IntStream;

public class InputView {

    private static final String BALL_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int BALL_COUNT = 3;
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
        List<Integer> rawBallList = InputConvertor.convertBalls(rawBalls);
        InputValidator.validateBallsCount(rawBallList);
        return IntStream.range(0, BALL_COUNT)
            .mapToObj(index -> {
                int position = index + 1;
                int ballNumber = rawBallList.get(index);
                return new Ball(position, ballNumber);
            }).collect(collectingAndThen(toList(), Balls::from));
    }

    public Retry scanRetry() {
        System.out.println(RETRY_INPUT_MESSAGE);
        String rawRetry = Console.readLine();
        InputValidator.validateRetry(rawRetry);
        Retry retry = InputConvertor.converRetry(rawRetry);
        return retry;

    }
}

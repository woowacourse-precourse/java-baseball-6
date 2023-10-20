package baseball;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.IntStream;

public class InputView {

    private static final String BALL_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int BALL_COUNT = 3;
    private static InputView instance;

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public static Balls scanBalls() {
        System.out.println(BALL_NUMBER_INPUT_MESSAGE);
        String rawBalls = Console.readLine();
        InputValidator.validateBalls(rawBalls);
        List<Integer> rawBallList = InputConvertor.convertBalls(rawBalls);
        Balls balls = IntStream.range(0, 3)
            .mapToObj(index -> {
                int position = index + 1;
                int ballNumber = rawBallList.get(index);
                return new Ball(position, ballNumber);
            }).collect(collectingAndThen(toList(), Balls::from));
        return balls;
    }
}

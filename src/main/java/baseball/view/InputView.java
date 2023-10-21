package baseball.view;

import baseball.domain.Ball;
import baseball.domain.Balls;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static Balls userInputNumber() {

        List<Ball> ballList = new ArrayList<>();

        System.out.print(INPUT_MESSAGE);
        String input = readLine();

        int position = 0;
        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            validateRange(digit);
            ballList.add(new Ball(digit, position++));
        }

        return new Balls(ballList);
    }

    private static void validateRange(int digit) {
        if (digit < MIN_NUMBER || MAX_NUMBER < digit) {
            throw new IllegalArgumentException();
        }
    }

    public static int RestartOrEnd() {
        System.out.println(END_MESSAGE);
        System.out.println(RESTART_OR_END_MESSAGE);
        return Integer.parseInt(readLine());
    }

}

package baseball.view;

import baseball.util.TypeConverter;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String READ_BALL_NUMBERS_MSG = "숫자를 입력해주세요 : ";

    public List<Integer> readBallNumbers() {
        System.out.print(READ_BALL_NUMBERS_MSG);
        return TypeConverter.toList(readLine());
    }
}

package baseball.view;

import baseball.model.RestartOption;
import baseball.util.TypeConverter;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String READ_BALL_NUMBERS_MSG = "숫자를 입력해주세요 : ";
    private static final String READ_RESTART_COMMAND_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public List<Integer> readBallNumbers() {
        System.out.print(READ_BALL_NUMBERS_MSG);
        return TypeConverter.toList(readLine());
    }

    public RestartOption readRestartCommand() {
        System.out.println(READ_RESTART_COMMAND_MSG);
        return RestartOption.from(readLine());
    }
}

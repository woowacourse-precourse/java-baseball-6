package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Balls;
import baseball.domain.ResponseStatus;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public static Balls userInputNumber() {
        System.out.print(INPUT_MESSAGE);
        return Balls.create(readLine());
    }

    public static ResponseStatus inputRestartOrEnd() {
        System.out.println(END_MESSAGE + RESTART_OR_END_MESSAGE);
        return ResponseStatus.from(readLine());
    }
}

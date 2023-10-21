package baseball.view;

import baseball.domain.Balls;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public static Balls userInputNumber() {
        System.out.print(INPUT_MESSAGE);
        return Balls.create(readLine());
    }

    public static int RestartOrEnd() {
        System.out.println(END_MESSAGE + RESTART_OR_END_MESSAGE);
        return Integer.parseInt(readLine());
    }

}

package baseball.view;

import baseball.domain.ball.GameStatus;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public final class InputView {

    private int executionCount = 0;

    public List<Integer> inputBallNumbers() {
        if (executionCount++ == 0) {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
        System.out.print("숫자를 입력해주세요 : ");

        return Arrays.stream(readLine().split(""))
                .map(Integer::parseInt)
                .toList();
    }

    private String readLine() {
        return Console.readLine().trim();
    }

    public GameStatus inputNextGameStatus() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        final GameStatus status = GameStatus.of(readLine());

        if (GameStatus.UNKNOWN == status) {
            System.out.println("잘못된 입력입니다. 반드시 1, 2 중 하나를 입력해야 합니다.");
            return inputNextGameStatus();
        }

        return status;
    }

}

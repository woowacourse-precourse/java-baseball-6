package baseball.view;

import baseball.domain.GameInfo;

import java.util.ArrayList;
import java.util.List;

public class SystemView {
    final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    final String BALL_MESSAGE = "%d볼";
    final String STRIKE_MESSAGE = "%d스트라이크";
    final String NOTHING_MESSAGE = "낫싱";
    final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void showStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void showInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }
    public void showResult(GameInfo gameInfo) {
        int strikeCount = gameInfo.getStrikeCount(), ballCount = gameInfo.getBallCount();
        List<String> gameResult = new ArrayList<>();

        if (ballCount == 0 && strikeCount == 0) gameResult.add(NOTHING_MESSAGE);
        if (ballCount != 0) gameResult.add(String.format(BALL_MESSAGE, ballCount));
        if (strikeCount != 0) gameResult.add(String.format(STRIKE_MESSAGE, strikeCount));

        System.out.println(String.join(" ", gameResult));
    }

    public void showWinMessage() {
        System.out.println(WIN_MESSAGE);
    }

    public void showRestartOrEndMessage() {
        System.out.println(RESTART_OR_END_MESSAGE);
    }
}

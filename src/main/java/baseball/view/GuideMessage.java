package baseball.view;

import baseball.global.Const;

public class GuideMessage {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String REQUEST_NUMBERS = "숫자를 입력해주세요 : ";
    public static final String GAME_WIN = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Const.STRIKE_COUNT);
    public static final String REQUEST_RESTART = String.format(
            "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", Const.RESTART_INPUT, Const.EXIT_INPUT);
}

package baseball.view;

import static baseball.utils.Constants.NUMBER_OF_BALLS;

public final class Messages {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_OVER_MESSAGE = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", NUMBER_OF_BALLS);
    public static final String INSERT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String INSERT_COMMAND_MESSAGE = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
            Command.RESTART.getValue(), Command.FINISH.getValue());
}

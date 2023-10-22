package baseball.domain;

import baseball.controller.RegameChoice;

public final class GameConstants {
    public static final int NUMBER_LENGTH = 3;
    public static final int MIN_DIGIT = 1;
    public static final int MAX_DIGIT = 9;

    public static final String STRIKE_TEXT = "스트라이크";
    public static final String BALL_TEXT = "볼";
    public static final String NOTHING_TEXT = "낫싱";

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String END_MESSAGE = String.format(
            "%d개의 숫자를 모두 맞히셨습니다! 게임 종료",
            NUMBER_LENGTH
    );
    public static final String RESTART_CHOICE_MESSAGE = String.format(
            "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
            RegameChoice.RESTART_GAME.getValue(),
            RegameChoice.EXIT_GAME.getValue()
    );

    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private GameConstants(){

    }
}
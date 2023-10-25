package baseball.config;

/**
 * 게임에 필요한 메시지들을 제공하는 클래스
 */
public class GameMessages {

    /** 게임 시작 메시지 */
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";

    /** 숫자 입력 요청 메시지 */
    public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";

    /**
     * 스트라이크 결과 메시지
     * <p>
     * 사용 예: {@code String.format(STRIKE, strikeCount);}
     */
    public static final String STRIKE = "%d스트라이크";

    /**
     * 볼 결과 메시지
     * <p>
     * 사용 예: {@code String.format(BALL, ballCount);}
     */
    public static final String BALL = "%d볼 ";

    /** 낫싱 결과 메시지 */
    public static final String NOTHING = "낫싱";

    /**
     * 게임 종료 메시지
     * <p>
     * 사용 예: {@code String.format(GAME_OVER, correctNumberCount);}
     */
    public static final String GAME_OVER = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";

    /**
     * 게임 재시작 또는 종료 선택 메시지
     * <p>
     * 사용 예: {@code String.format(REPLAY_OR_STOP, replayOption, stopOption);}
     */
    public static final String REPLAY_OR_STOP = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.";
}


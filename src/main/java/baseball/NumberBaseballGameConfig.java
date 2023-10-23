package baseball;

public class NumberBaseballGameConfig {

    // 게임 설정 상수 정의
    public static final int BASEBALL_NUMBER_LENGTH = 3;
    public static final int MIN_PLACE_VALUE = 1;
    public static final int MAX_PLACE_VALUE = 9;
    public static final int CONTINUE_GAME = 1;
    public static final int EXIT_GAME = 2;
    public static final int STRIKE_COUNT_REQUIRED_TO_WIN = 3;

    // 메시지 관련 상수
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_PROMPT = "숫자를 입력해주세요 : ";
    public static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    // 에러 메시지
    public static final String ERROR_LENGTH = "입력의 길이가 잘못되었습니다.";
    public static final String ERROR_TYPE = "입력의 타입이 잘못되었습니다.";
    public static final String ERROR_RANGE = "입력의 범위가 잘못되었습니다.";
    public static final String ERROR_DUPLICATE = "중복된 숫자가 입력되었습니다.";

    // 의존 객체 관리
    private final InputReader inputReader;
    private final Referee referee;
    private final RandomNumberGenerator randomNumberGenerator;
    private final Announcer announcer;

    public NumberBaseballGameConfig() {
        this.inputReader = new InputReader(new GuessedNumberValidator(), new ContinueModeNumberValidator());
        this.referee = new Referee();
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.announcer = new Announcer();
    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public Referee getReferee() {
        return referee;
    }

    public RandomNumberGenerator getRandomNumberGenerator() {
        return randomNumberGenerator;
    }

    public Announcer getAnnouncer() {
        return announcer;
    }
}

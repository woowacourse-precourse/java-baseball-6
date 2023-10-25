package baseball;

public enum PrintMessage {

    START       ( "숫자 야구 게임을 시작합니다." ),
    ASK_INPUT   ( "숫자를 입력해주세요 : " ),
    CLEAR       ( "3개의 숫자를 모두 맞히셨습니다! 게임 종료" ),
    RESTART     ( "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." ),
    ERROR       ( "잘못된 입력입니다." )
    ;

    private final String message;

    PrintMessage( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String resultGame( CheckInputNum checkInputNum ) {

        final String STRIKE = "스트라이크";
        final String BALL = "볼";
        final String NOTHING = "낫싱";

        int strike = checkInputNum.getStrike();
        int ball = checkInputNum.getBall();

        return ( strike > 0 ? strike + STRIKE : "" )
                + ( ball > 0 ? ball + BALL : "" )
                + ( strike == 0 && ball == 0 ? NOTHING : "" );
    }
}

package baseball.enums;

/**
 * 게임 결과 타입
 */
public enum GameResultType {

    BALL("볼"), // 숫자 O 자리 X
    STRIKE("스트라이크"), // 숫자 O 자리 O
    NOTHING("낫싱") // 숫자 X 자리 X
    ;

    private String resultString;

    GameResultType(String resultString) {
        this.resultString = resultString;
    }

    public String getResultString() {
        return resultString;
    }

}

package baseball;

public enum Result {
    BALL_RESULT("볼"),
    STRIKE_RESULT("스트라이크"),
    NOTHING_RESULT("낫싱"),
    ALL_STRIKE_RESULT("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private String result;

    Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

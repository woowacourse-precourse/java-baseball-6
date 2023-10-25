package baseball.global.message;

public enum BallMessage {
    BALL("볼") {public String apply(int number) {return number+"볼";}},
    STRIKE("스트라이크"){public String apply(int number) {return number+"스트라이크";}},
    NOTHING("낫싱"){public String apply(int number) {return "낫싱";}};

    private final String message;

    BallMessage(String message) {
        this.message = message;
    }


    public abstract String apply(int number);

    public String getMessage() {
        return message;
    }
}

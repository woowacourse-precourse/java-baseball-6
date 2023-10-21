package baseball.domain;

public enum BallStatus {

    BALL(1, "볼"), STRIKE(2,"스트라이크"),  NOTHING(3, "낫싱");

    private final int order;
    private final String name;

    BallStatus(int order, String name) {
        this.order = order;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }
}
package baseball.dto;

public class BattedBallsDTO {
    private final String battedBalls;

    private BattedBallsDTO(String battedBalls) {
        this.battedBalls = battedBalls;
    }

    public static BattedBallsDTO from(String battedBalls) {
        return new BattedBallsDTO(battedBalls);
    }

    public String getBattedBalls() {
        return battedBalls;
    }
}

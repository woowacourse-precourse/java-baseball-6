package baseball.controller;

public class BallDto {
    private final Integer number;

    public BallDto(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}

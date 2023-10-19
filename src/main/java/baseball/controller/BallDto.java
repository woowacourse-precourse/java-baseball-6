package baseball.controller;

public class BallDto {
    private Integer number;

    public BallDto(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BallDto ballDto = (BallDto) o;

        return getNumber().equals(ballDto.getNumber());
    }

    @Override
    public int hashCode() {
        return getNumber().hashCode();
    }
}

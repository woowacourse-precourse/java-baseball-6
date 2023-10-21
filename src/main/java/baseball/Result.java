package baseball;

public record Result(Integer strike, Integer ball) {

    public Result {
        if (strike < 0 || ball < 0) {
            throw new IllegalArgumentException("스트라이크와 볼은 0보다 작을 수 없습니다.");
        }
    }

    public boolean isEndGame() {
        return strike == 3;
    }
}

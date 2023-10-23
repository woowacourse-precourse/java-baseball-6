package baseball;

public enum Count {
    STRIKE("스트라이크"),
    BALL("볼 ");

    private final String countMark;

    Count(String countMark) {
        this.countMark = countMark;
    }

    public String getCountMarkFrom(int count) {
        if (count < 1) {
            return "";
        }

        return count + countMark;
    }
}

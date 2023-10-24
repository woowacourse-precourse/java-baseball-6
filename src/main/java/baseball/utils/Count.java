package baseball.utils;

public enum Count {
    STRIKE("스트라이크"),
    BALL("볼 ");

    //---Constants---
    private static final String EMPTY_STRING = "";
    private static final int NO_COUNT = 0;
    //---------

    private final String countMark;

    Count(String countMark) {
        this.countMark = countMark;
    }

    public String getCountMarkFrom(int count) {
        if (count == NO_COUNT) {
            return EMPTY_STRING;
        }

        return count + countMark;
    }
}

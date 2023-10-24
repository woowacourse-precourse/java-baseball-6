package baseball;

public record Ball(Number number, Position position) {

    public static Ball of(final int number, final int position) {
        return new Ball(Number.of(number), Position.of(position));
    }

    public CompareResult compare(final Ball other) {
        if (this.equals(other)) {
            return CompareResult.STRIKE;
        }
        if (matchNumber(other)) {
            return CompareResult.BALL;
        }
        return CompareResult.NOTHING;
    }

    private boolean matchNumber(final Ball other) {
        return number.equals(other.number);
    }
}

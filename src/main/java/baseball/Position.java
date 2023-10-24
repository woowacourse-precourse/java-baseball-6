package baseball;

public record Position(int position) {

    public static Position of(final int position) {
        return new Position(position);
    }
}

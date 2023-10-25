package baseball;

public record Ball(int number, int location) {
    public boolean isStrike(Ball other) {
        return this.equals(other);
    }

    public boolean isBall(Ball other) {
        return number == other.number() &&
                location != other.location();
    }
}

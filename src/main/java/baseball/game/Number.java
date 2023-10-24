package baseball.game;

public class Number {
    public final int num;

    public Number(char num) {
        if (Character.isDigit(num)) {
            this.num = validateZero(Character.getNumericValue(num));
        } else {
            throw new IllegalArgumentException("is not digit");
        }
    }

    public Number(int num) {
        validateZero(num);
        this.num = num;
    }

    public int validateZero(int num) {
        if (num == 0) {
            throw new IllegalArgumentException("0 is not allowed.");
        }
        return num;
    }

    public boolean equals(Number obj) {
        return this.num == obj.num;
    }
}

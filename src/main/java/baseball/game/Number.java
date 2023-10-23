package baseball.game;

public class Number {
    public final int num;

    public Number(char num) {
        if (Character.isDigit(num)) {
            this.num = Character.getNumericValue(num);
        } else {
            throw new IllegalArgumentException("is not digit");
        }
    }

    public Number(int num) {
        this.num = num;
    }

    public boolean equals(Number obj) {
        return this.num == obj.num;
    }
}

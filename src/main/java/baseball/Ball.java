package baseball;

public class Ball {
    private final int number;

    public Ball(int number) {
        validate(number);
        this.number = number;
    }

    public Ball(char ch) {
        this( Integer.parseInt(String.valueOf(ch)) );
    }

    public int getNumber() { return number; }

    public void validate(int number) {
        if ( number < 1 || 9 < number ) throw new IllegalArgumentException("공의 숫자는 1~9의 자연수만 가능합니다.");
    }

    public boolean equals(Object obj) {
        Ball ball = (Ball)obj;

        return this.number == ball.number;
    }

    public String toString() {
        return String.valueOf(this.number);
    }
}

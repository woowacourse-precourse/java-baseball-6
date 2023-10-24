package baseball;

public class Ball {
    private int number;

    public Ball(String number) {
        isDigit(number);
        this.number = Integer.parseInt(number);
    }

    private void isDigit(String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException("숫자가 아니면 Ball을 생성할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return number == ball.number;
    }
}

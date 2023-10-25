package baseball;

public class Ball{
    private static final Integer number;

    public Ball(int number){
        validateRange(number);
        this.number = number;
    }
    private void validateRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("공의 숫자는 1~9의 자연수만 가능합니다.");
        }
    }

    public boolean equals(Object obj) {
        Ball ball = (Ball)obj;
        return this.number.equals(ball.number); //공 숫자 확인에 대해 boolean함수 처리
    }

    public String toString() {
        return this.number.toString();
    }


}
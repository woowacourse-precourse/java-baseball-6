package baseball.model;

public class Number {
    public int number;

    public Number(int number) {
        if(!isValidNumber(number))
            throw new IllegalArgumentException("입력 값은 1부터 9가지의 숫자여야 합니다.");
        this.number = number;
    }

    public boolean isValidNumber(int number){
        return (0<number && number<10);
    }

    public boolean isequal(Number number) {
        return this.number==number.number;
    }
}

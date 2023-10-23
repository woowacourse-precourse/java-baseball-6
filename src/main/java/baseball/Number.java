package baseball;

public class Number {
    int number;
    Number(int number){
        validateIsNumber(number);
        this.number = number;
    }
    public void validateIsNumber(int input){
        if(input <= 0 || input > 9){
            throw new IllegalArgumentException("1에서 9사이 숫자를 입력해주세요.");
        }
    }
    public boolean isSame(Number n){
        return n.number == this.number;
    }

    @Override
    public boolean equals(Object obj) {
        Number n = (Number) obj;
        return n.number == this.number;
    }
}

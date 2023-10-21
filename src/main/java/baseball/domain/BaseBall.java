package baseball.domain;

public class BaseBall {
    private final int number;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_NUMBER = 1;

    public BaseBall(int number) {
        this.number = number;
        validate();
    }

    private void validate(){
        // TODO : 1부터 9사이의 숫자를 입력하도록 요구 (예외처리)
    }

    public static BaseBall toBaseBall(int number){
        return new BaseBall(number);
    }
}

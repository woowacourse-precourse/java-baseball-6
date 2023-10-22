package baseball.Exception;

public class NumberOfInputException extends IllegalArgumentException{
    public NumberOfInputException(){
        super("3개의 숫자를 입력해주세요.");
    }
}

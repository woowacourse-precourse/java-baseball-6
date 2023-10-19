package baseball.domain;

public class Baseball {
    
    public static final int BASEBALL_NUMBERS_SIZE = 3;
    
    private final String number;
    
    public Baseball(String number) {
        validateSize(number);
        validateDuplicate(number);
        this.number = number;
    }
    
    public String getNumber() {
        return number;
    }
    
    private void validateDuplicate(String number) {
        if (number.length() != BASEBALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException("입력한 숫자에 중복이 있습니다");
        }
    }
    
    private void validateSize(String number) {
        if (number.length() != BASEBALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format(
                    "%d개의 자릿수만 허용됩니다.", BASEBALL_NUMBERS_SIZE));
        }
    }
}

package baseball.domain;

public class Computer {
    
    public static final int BASEBALL_NUMBERS_SIZE = 3;
    
    private String number;
    
    public Computer(String number) {
        this.number = number;
    }
    
    public String getNumber() {
        return number;
    }
}

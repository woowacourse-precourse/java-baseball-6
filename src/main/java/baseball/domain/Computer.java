package baseball.domain;

public class Computer {
    
    private final Baseball baseball;
    
    public Computer(String number) {
        this.baseball = new Baseball(number);
    }
    
    public String getNumber() {
        return baseball.getNumber();
    }
}

package baseball.domain;
public class Computer {
    private String computerNumber;
    private static Computer instance;
    private Computer() {
    }
    public static Computer getInstance() {
        if (instance == null) {
            instance = new Computer();
        }
        return instance;
    }
    public String getComputerNumber() {
        return computerNumber;
    }
    public void setComputerNumber(String computerNumber) {
        this.computerNumber = computerNumber;
    }
    public void clearInstance(){
        instance = new Computer();
    }
}

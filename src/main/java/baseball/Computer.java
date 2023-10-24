package baseball;

public class Computer {
    private ComputerBaseballNumber computerBaseballNumber;
    public void generateComputerBaseballNumber(){
        computerBaseballNumber = new ComputerBaseballNumber();
    }
    public BaseballGameResult getBaseballGameResult(UserBaseballNumber userBaseballNumber){
        return new BaseballGameResult(computerBaseballNumber, userBaseballNumber);
    }
}

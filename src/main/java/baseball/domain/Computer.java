package baseball.domain;

public class Computer {

    private int firstNum;
    private int secondNum;
    private int thirdNum;

    public Computer(int firstNum, int secondNum, int thirdNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.thirdNum = thirdNum;
    }


    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public int getThirdNum() {
        return thirdNum;
    }

    public void setThirdNum(int thirdNum) {
        this.thirdNum = thirdNum;
    }

    public void setAllNum(int firstNum, int secondNum, int thirdNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.thirdNum = thirdNum;
    }

}

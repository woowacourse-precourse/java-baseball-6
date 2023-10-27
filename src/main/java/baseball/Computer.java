package baseball;

public class Computer {
    private BaseballNum computerNum;

    public Computer() {
        computerNum = new BaseballNum();
    }

    boolean checkNum(BaseballNum userNum) {
        if (userNum == null) {
            return (false);
        }
        int strike = computerNum.isSamePositionNum(userNum);
        int ball = computerNum.isContainsNum(userNum) - strike;
        Printer.printBaseballCount(strike, ball);
        return (strike == 3);
    }
}

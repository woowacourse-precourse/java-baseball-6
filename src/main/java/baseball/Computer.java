package baseball;

public class Computer {
    private BaseballNum computerNum;

    public Computer() {
        computerNum = new BaseballNum();
    }

    boolean checkNum(BaseballNum userNum) {
        int strike;
        int ball;

        if (userNum == null) {
            return (false);
        }
        strike = computerNum.isSamePositionNum(userNum);
        ball = computerNum.isContainsNum(userNum) - strike;
        Printer.baseball(strike, ball);
        return (strike == 3);
    }
}

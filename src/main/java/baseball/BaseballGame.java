package baseball;

public class BaseballGame {
    private BaseballGameComputer computer;
    private BaseballGameUser user;

    public BaseballGame() {
        computer = new BaseballGameComputer();
        user = new BaseballGameUser();
    }

    public void printResult(String userNum) {
        computer.printResult(userNum);
    }

    public boolean isWin(String userNum) {
        return computer.isWin(userNum);
    }

    public void updateGoalNum() {
        computer.updateGoalNum();
    }

    public void updateUserNum(String userNum) {
        user.updateUserNum(userNum);
    }

}

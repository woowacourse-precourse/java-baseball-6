package baseball;

public class Game {
    private Computer computer;
    private User user;
    private Result result;

    public void run() {
        setGame();
        playGame();
    }

    private void setGame() {
        computer = new Computer();
        user = new User();
        result = new Result();
    }

    private void playGame() {
        while (!result.isThreeStrike()) {
            user.inputNumbers();
            result.checkResult(user.getNumbers(), computer.getNumbers());
            result.printResult();
        }
    }
}

package baseball;

public class Game {
    private Computer computer;
    private User user;

    public void run() {
        setGame();
    }

    private void setGame() {
        computer = new Computer();
        user = new User();
    }
}

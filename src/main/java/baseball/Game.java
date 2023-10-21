package baseball;


public class Game {
    private boolean end;
    private Computer computer;
    private User user;

    Game() {
        end = false;
        computer = new Computer();
        user = new User();
    }
    public void doGame() {
        do {
            startGame();
            inGame();
            endGame();
        } while (end == false);
    }

    public void startGame() {

    }

    public void inGame() {

    }

    public void endGame() {

    }
}

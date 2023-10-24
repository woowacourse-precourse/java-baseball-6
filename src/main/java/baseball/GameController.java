package baseball;

public class GameController {

    private Computer computer;
    private User user;

    public GameController() {
        this.computer = new Computer();
        this.user = new User();
    }

    public void run() {
        while (true) {
            computer.generateRandomNumbers();
            if (!playGame()) {
                break;
            }
        }
    }

    public boolean playGame() {
        while (true) {
            if (computer.compareNumbers(user.getNumbersFromUser())) {
                return user.restartGame();
            }
        }
    }

}

package baseball;

public class GameController {

    private Computer computer;
    private User user;

    public GameController() {
        this.computer = new Computer();
        this.user = new User();
    }

    public void run() {
        while (user.getGameStatus()) {
            computer.generateRandomNumbers();
            gameStart();
        }
    }

    public void gameStart() {
        while (true) {
            user.getNumbersFromUser();
            if (compareNumbers(user.getNumbers(), computer.getRandomNumbers())) {
                user.restartGame();
                break;
            }
        }

    }

}

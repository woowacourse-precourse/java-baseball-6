package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        GameManager gameManager = new GameManager();
        User user = new User();
        Computer computer = new Computer();
        gameManager.startMessage();
        while (true) {
            String result = gameManager.startGame(user, computer);
            System.out.println(result);
            if (gameManager.isCompleted(result)) {
                gameManager.endMessage();
                gameManager.restartGameMessage();
                if (!gameManager.doGameAgain(user.readLineForRestartGame(), computer)) break;
            }
        }
        gameManager.exitMessage();
    }
}

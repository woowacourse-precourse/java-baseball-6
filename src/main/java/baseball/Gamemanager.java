package baseball;


public class Gamemanager {
    public static final int RETRY_COMMAND = 1;
    public static final int END_COMMAND = 2;

    private Computer computer;
    private User user;
    private GameResult gameResult;

    public void start() { //하나의 게임 시작. 큰 반복문
        Message.printStartMessage();
        do {
            setGame();
            playGame();
        } while (isRestart());

        Message.printEndMessage();
    }

    private boolean isRestart() {
        Message.printRestartMessage();
        int userInput = Input.restartInput();
        if (userInput == RETRY_COMMAND) {
            return true;
        }
        else {
            Message.printEndMessage();
            return false;
        }
    }

    private void setGame() {
        this.computer = new Computer();
        this.user = new User();
    }

    private void playGame() {
        while (true) {
            Message.printInputMessage();
            this.user.setUserNumbers(Input.userInput());
            this.gameResult = new GameResult(user.getUserNumbers(), computer.getComputerNumbers());
            if (gameResult.isWin()) {
                System.out.println(gameResult.getResult());
                Message.printWinMessage();
                break;
            }
            System.out.println(gameResult.getResult());
        }
    }

}

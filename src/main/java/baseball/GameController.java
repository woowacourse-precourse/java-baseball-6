package baseball;

public class GameController {
    private final Computer computer;
    private final Player player;
    private static final int TERMINATE_INPUT = 2;


    public GameController() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.computer = new Computer();
        this.player = new Player();
    }

    public void startGame() {
        boolean isGameEnd = false;
        do {
            // New Game
            computer.generateRandomNumbers();

            // Game
            while (true) {
                player.getUserInput();
                Score playerScore = computer.guess(player.getNumbers());
                System.out.println(playerScore.getScoreResult());
                if (playerScore.isThreeStrikes()) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    Integer restartOrEnd = player.getRestartOrEnd();
                    if (restartOrEnd == TERMINATE_INPUT) {
                        isGameEnd = true;
                    }
                    break;
                }
            }

            // Restart Game?
        } while (!isGameEnd);
    }
}

package baseball;

public class GameController {
    public Computer computer;
    public Player player;


    public GameController() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isGameEnd = false;

        while (true) {
            // New Game
            computer = new Computer();
            player = new Player();
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
                    if (restartOrEnd == 2) {
                        isGameEnd = true;
                    }
                    break;
                }
            }
            if (isGameEnd) {
                break;
            }
        }


    }
}

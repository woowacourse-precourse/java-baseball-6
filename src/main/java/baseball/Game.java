package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    private final RandomNumberGenerator randomNumberGenerator;

    private Game(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public static Game startNewGame() {
        return new Game(RandomNumberGenerator.generateThreeDigits());
    }

    public String play(List<Integer> playerNumbers) {
        int ballCounts = 0;
        int strikeCounts = 0;
        List<Integer> randomNumbers = randomNumberGenerator.getNumbers();

        for (int i = 0; i < playerNumbers.size(); i++) {
            int playerNumber = playerNumbers.get(i);
            int randomNumber = randomNumbers.get(i);

            if (playerNumber == randomNumber) {
                strikeCounts++;
                continue;
            }

            if (randomNumbers.contains(playerNumber)) {
                ballCounts++;
            }
        }

        return generateResultMessage(ballCounts, strikeCounts);
    }

    private String generateResultMessage(int ballCounts, int strikeCounts) {
        if (ballCounts == 0 && strikeCounts == 0) {
            return "낫싱";
        }

        return (ballCounts > 0 ? ballCounts + "볼 " : "") + (strikeCounts > 0 ? strikeCounts + "스트라이크" : "");
    }

    public void gameLoop() {
        while (true) {
            Player player = Player.fromUserInput();
            List<Integer> playerNumbers = player.getPlayerNumbers();

            String result = play(playerNumbers);
            System.out.println(result);

            if (result.contains("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                if (isRestartGame()) {
                    Game newGame = Game.startNewGame();
                    newGame.gameLoop();
                }
                break;
            }
        }
    }

    private boolean isRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int isRestart = Integer.parseInt(Console.readLine());

        return isRestart == 1;
    }
}

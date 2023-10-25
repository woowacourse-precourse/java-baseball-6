package baseball;

import java.util.List;

public class Game {

    private final RandomNumberGenerator randomNumberGenerator;

    private Game(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public static Game startNewGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return new Game(RandomNumberGenerator.generateThreeDigits());
    }

    public String play(List<Integer> playerNumbers) {
        int strikeCounts = 0;
        int ballCounts = 0;

        for (int i = 0; i < playerNumbers.size(); i++) {
            List<Integer> randomNumbers = randomNumberGenerator.getNumbers();
            int randomNumber = randomNumbers.get(i);
            int playerNumber = playerNumbers.get(i);

            if (playerNumber == randomNumber) {
                strikeCounts++;
                continue;
            }

            if (randomNumbers.contains(playerNumber)) {
                ballCounts++;
            }
        }

        if (strikeCounts == 0 && ballCounts == 0) {
            return "낫싱";
        }

        return (ballCounts > 0 ? ballCounts + "볼 " : "") + (strikeCounts > 0 ? strikeCounts + "스트라이크" : "");
    }
}

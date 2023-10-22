package baseball;

import java.util.Arrays;
import java.util.List;

public class Game {
    private static Computer computer;
    private static User user;

    public Game() {
        this.computer = new Computer();
        this.user = new User();
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> randomScore = this.computer.getRandomScore();
        while (true) {
            List<Integer> userScore = this.user.getNumberFromUser();

        }

    }

    private List<Integer> compareScores(List<Integer> userScore, List<Integer> computerScore) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < userScore.size(); i++) {
            int userDigit = userScore.get(i);
            int computerDigit = computerScore.get(i);

            if (userDigit == computerDigit) {
                strikes++;
            } else if (computerScore.contains(userDigit)) {
                balls++;
            }
        }
        return Arrays.asList(strikes, balls);
    }

    
}

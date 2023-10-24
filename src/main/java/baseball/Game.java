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
            if (this.printGameResult(this.compareScores(randomScore, userScore))) {
                break;
            }
        }
    }

    public boolean isRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return this.user.getUserChoice();
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

    private boolean printGameResult(List<Integer> result) {
        int strikes = result.get(0);
        int balls = result.get(1);

        if (strikes == 3) {
            System.out.println("3스트라이크");
            return true;
        } else {
            String message = "";
            if (balls > 0) {
                message += balls + "볼";
            }
            if (strikes > 0) {
                if (!message.isEmpty()) {
                    message += " ";
                }
                message += strikes + "스트라이크";
            }
            if (message.isEmpty()) {
                message = "낫싱";
            }
            System.out.println(message);
        }
        return strikes == 3;
    }

}

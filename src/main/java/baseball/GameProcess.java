package baseball;

import java.util.List;
import java.util.Objects;

public class GameProcess {
    public static void gameStart() {
        List<Integer> computer = Computer.computerNumber();
        Score score = new Score();

        while (score.getStrike() != 3) {
            List<Integer> player = getPlayerNumber();
            countScore(player, computer, score);
            printScore(score);
            System.out.println(computer);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        // computer와 player 확인 작업(이후 삭제 예정)
        System.out.println(computer);
//        System.out.println(player);
    }

    public static List<Integer> getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> playerNumber = Player.playerNumber();
        return playerNumber;
    }

    public static void countScore(List<Integer> player, List<Integer> computer, Score score) {
        int strike = Score.countStrike(player, computer);
        int ball = Score.countBall(player, computer);
        score.setScore(strike, ball);
    }

    public static void printScore(Score score) {
        score.printGameResult(score.getStrike(), score.getBall());
    }

}

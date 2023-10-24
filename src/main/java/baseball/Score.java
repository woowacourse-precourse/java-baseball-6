package baseball;

import java.util.List;

public class Score {
    private static Integer ball;
    private static Integer strike;

    private Score() {
    }

    public static int calculateScore(List<Integer> computer, List<Integer> player) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(player.get(i))) {
                ball++;
            }
        }
        showScore();
        return strike;
    }

    private static void showScore() {
        if (ball != 0) {
            System.out.printf("%d볼 ", ball);
        }
        if (strike != 0) {
            System.out.printf("%d스트라이크", strike);
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}

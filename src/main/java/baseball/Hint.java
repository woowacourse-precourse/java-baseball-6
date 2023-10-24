package baseball;

public class Hint {

    public static int calStrike(String answer, String userNum) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == userNum.charAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    public static int calBall(String answer, String userNum) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) != userNum.charAt(i) && answer.indexOf(userNum.charAt(i)) != -1) {
                balls++;
            }
        }
        return balls;
    }

    public static boolean printHint(int ball, int strike) {

        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (ball > 0 && strike == 0) {
            System.out.printf("%d볼\n", ball);
        }

        if (ball == 0 && strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
            return false;
        }

        if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
        return false;
    }
}

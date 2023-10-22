package baseball;

public class CheckNum {
    private int strike = 0;
    private int ball = 0;
    private String result;

    private void check_score(Number user, Number com) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < user.getLength(); i++) {
            int index = com.matchNumber(user.getNumber(i));
            if (index == i) {
                strike++;
            }
            if (index != i && index > -1) {
                ball++;
            }
        }
        System.out.println("strike = " + strike);
        System.out.println("ball = " + ball);
    }

    public boolean print_score(Number user, Number com) {
        check_score(user, com);
        if (ball > 0) {
            result += ball + "볼 ";
        }
        if (strike > 0) {
            result += strike + "스트라이크";
        }
        if (strike == 0 && ball == 0) {
            result = "낫싱";
        }
        System.out.println(result);
        if (strike == 3) {
            return true;
        }
        return false;
    }

    public void start_score() {
        ball = 0;
        strike = 0;
        result = "";
    }
}

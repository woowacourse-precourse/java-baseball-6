package runGame;

public class Judge {

    public String isStrike(String s, String computer_num) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < computer_num.length(); j++) {
                if ((i == j) && s.charAt(i) == computer_num.charAt(j)) {
                    strike++;
                } else if (s.charAt(i) == computer_num.charAt(j)) {
                    ball++;
                }
            }
        }
        return NumOfStrikeAndBall(strike, ball);
    }

    private String NumOfStrikeAndBall(int strike, int ball) {
        String answer = " ";

        if (strike == 0 && ball == 0) {
            answer = "낫싱";
        } else if (strike > 0 && ball == 0) {
            answer = strike + "스트라이크";
        } else if (strike == 0 && ball > 0) {
            answer = ball + "볼";
        } else if (strike > 0 && ball > 0) {
            answer = ball + "볼 " + strike + "스트라이크";
        } else {
            answer = "3스트라이크";
        }

        return answer;
    }

}

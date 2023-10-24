package baseball;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Referee {
    private static final String START_GAME_MENT = "숫자 야구 게임을 시작합니다.";
    Validator validator = new Validator();
    Computer computer = new Computer();
    User user = new User();
    
    public Boolean countBallAndStrike(List<Integer> strikeAndBall) {//카운트 세주는
        int strike = strikeAndBall.get(0);
        int ball = strikeAndBall.get(1);
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            return TRUE;
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
        return FALSE;
    }
    public List<Integer> judgeNum(String baseballNum, String userInputNum) {
        int strike = 0;
        int ball = 0;
        int len = userInputNum.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((i == j) && (baseballNum.charAt(i) == userInputNum.charAt(j))) {
                    strike++;
                    continue;
                }
                if ((i != j) && (baseballNum.charAt(i) == userInputNum.charAt(j))) {
                    ball++;
                    continue;
                }
            }
        }
        return List.of(strike, ball);
    }
}

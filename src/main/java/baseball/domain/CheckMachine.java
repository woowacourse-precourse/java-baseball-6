package baseball.domain;

import java.util.List;

public class CheckMachine {
    BallCount ballCount = new BallCount();
    // 정답과 답변 비교 메서드
    public String checkAnswer(List<Integer> generatedAnswer, List<Integer> pickNumbers) {
        int strike = 0;
        int ball = 0;
        String result;
        for(int i = 0; i<GameRules.INPUT_LIMIT.getBalls(); i++) {
            if(ballCount.isStrike(generatedAnswer, pickNumbers)) {
                ballCount.plusStrike();
            }else if(ballCount.isBall(generatedAnswer, pickNumbers)) {
                ballCount.plusBall();
            }
        }
        if(ballCount.isAllStrike(strike)) {
            result = "3스트라이크";
        }else if(ballCount.isNothing(strike, ball)) {
            result = "낫싱";
        }else {
            result =  ball + "볼 " + strike + "스트라이크";
        }
        return result;
    }
}

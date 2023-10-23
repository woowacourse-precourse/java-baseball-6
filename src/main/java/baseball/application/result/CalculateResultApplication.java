package baseball.application.result;

import baseball.domain.*;

public class CalculateResultApplication {

    private static BaseballRepository baseballRepository = BaseballRepository.getInstance();
    private AnswerNumberRepository answerNumberRepository = AnswerNumberRepository.getInstance();
    private UserNumberRepository userNumberRepository = UserNumberRepository.getInstance();



    public CalculateResultApplication() {
        calculateResult();
    }

    private void calculateResult() {
        baseballRepository.clear();
        for (int i = 0; i < 3; i++) {
            // 개수
            if (userNumberRepository.contain(answerNumberRepository.findById(i))) {
                baseballRepository.addBall();
            }
            // 위치
            if (userNumberRepository.findById(i).equals(answerNumberRepository.findById(i))) {
                baseballRepository.subBall();
                baseballRepository.addStrike();
            }
        }
        System.out.println("ball: " + baseballRepository.getBall() + ", strike : " + baseballRepository.getStrike());
    }


}

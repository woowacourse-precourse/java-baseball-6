package baseball.application.result;

import baseball.domain.*;

public class CalculateResultApplication {

    private static BaseballResultRepository baseballResultRepository = BaseballResultRepository.getInstance();
    private AnswerNumberRepository answerNumberRepository = AnswerNumberRepository.getInstance();
    private UserNumberRepository userNumberRepository = UserNumberRepository.getInstance();



    public CalculateResultApplication() {
        calculateResult();
    }

    private void calculateResult() {
        baseballResultRepository.clear();
        for (int i = 0; i < 3; i++) {
            // 개수
            if (userNumberRepository.contain(answerNumberRepository.findById(i))) {
                baseballResultRepository.addBall();
            }
            // 위치
            if (userNumberRepository.findById(i).equals(answerNumberRepository.findById(i))) {
                baseballResultRepository.subBall();
                baseballResultRepository.addStrike();
            }
        }
//        System.out.println("ball: " + baseballResultRepository.getBall() + ", strike : " + baseballResultRepository.getStrike());
    }


}

package baseball.application.result;

import baseball.domain.AnswerNumberRepository;
import baseball.domain.BaseballResultRepository;
import baseball.domain.UserNumberRepository;

public class CalculateResultApplication {

    private static final BaseballResultRepository baseballResultRepository = BaseballResultRepository.getInstance();
    private static final AnswerNumberRepository answerNumberRepository = AnswerNumberRepository.getInstance();
    private static final UserNumberRepository userNumberRepository = UserNumberRepository.getInstance();


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

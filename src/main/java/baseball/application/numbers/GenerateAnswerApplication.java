package baseball.application.numbers;

import baseball.domain.AnswerNumberRepository;
import camp.nextstep.edu.missionutils.Randoms;

public class GenerateAnswerApplication {
    private static AnswerNumberRepository answerNumberRepository = AnswerNumberRepository.getInstance();

    public GenerateAnswerApplication() {
        generateNumbers();
    }

    public void generateNumbers() {
        while (answerNumberRepository.size() < 3){
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberRepository.contain(pickNumber)){
                answerNumberRepository.addValue(pickNumber);
            }
        }
//        System.out.println("answer: " + answerNumberRepository.getNumbers());
    }

    public void initilizeAnswer() {
        answerNumberRepository.clear();
    }
}

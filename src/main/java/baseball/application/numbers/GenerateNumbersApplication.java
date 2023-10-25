package baseball.application.numbers;

import baseball.domain.AnswerNumberRepository;
import camp.nextstep.edu.missionutils.Randoms;

public class GenerateNumbersApplication {
    private static final AnswerNumberRepository answerNumberRepository = AnswerNumberRepository.getInstance();

    public GenerateNumbersApplication() {
        generateNumbers();
    }

    public void generateNumbers() {
        while (answerNumberRepository.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberRepository.contain(pickNumber)) {
                answerNumberRepository.addValue(pickNumber);
            }
        }
//        System.out.println("answer: " + answerNumberRepository.getNumbers());
    }

    public void initilizeNumbers() {
        answerNumberRepository.clear();
    }
}

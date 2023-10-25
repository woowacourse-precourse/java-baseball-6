package baseball.service;

import baseball.domain.Hint;
import baseball.domain.Numbers;
import baseball.repository.AnswerRepository;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void saveAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        answerRepository.save(new Numbers(computer));
    }

    public Hint getHint(Numbers input) {
        Numbers answer = answerRepository.find();
        List<Integer> inputNumbers = input.getNumbers();
        List<Integer> answerNumbers = answer.getNumbers();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            Integer inputNumber = inputNumbers.get(i);
            Integer answerNumber = answerNumbers.get(i);
            if (inputNumber.equals(answerNumber)) {
                strike++;
            } else if (answerNumbers.contains(inputNumber)) {
                ball++;
            }
        }
        return new Hint(strike, ball);
    }
}

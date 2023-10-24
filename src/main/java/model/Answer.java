package model;

import static model.Constant.MAX_RANDOM_NUMBER;
import static model.Constant.MIN_RANDOM_NUMBER;
import static model.Constant.NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Integer> answer;

    public Answer() {
        setAnswerNumber();
    }

    public void setAnswerNumber() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        this.answer = answer;
    }

    public List<Integer> getAnswerNumber() {
        return this.answer;
    }
}

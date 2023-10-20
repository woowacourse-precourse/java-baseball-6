package baseball;

import java.util.ArrayList;
import java.util.List;

/*
* 게임을 관리하는 클래스
* */
public class BaseballGame {
    Answer answer;

    public Answer answerGenerate() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> answerNumbers = new ArrayList<>();
        while (answerNumbers.size() < 3) {
            int randomNumber = randomNumberGenerator.getRandoms();
            if (!answerNumbers.contains(randomNumber)) {
                answerNumbers.add(randomNumber);
            }
        }
        answer = new Answer(answerNumbers);
        return answer;
    }


}

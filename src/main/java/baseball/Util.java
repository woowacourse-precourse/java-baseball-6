package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public List<Integer> getRandomNumber() {

        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public Score getScore(List<Integer> answerNumbers, List<Integer> userNumbers) {

        Score score = new Score();
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < answerNumbers.size(); i++) {
            for(int j = 0; j < userNumbers.size(); j++) {
                if(i == j && answerNumbers.get(i) == userNumbers.get(j)) {
                    strike++;
                    continue;
                }
                if(answerNumbers.get(i) == userNumbers.get(j)) {
                    ball++;
                }
            }
        }

        score.setStrike(strike);
        score.setBall(ball);
        return score;
    }
}

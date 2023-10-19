package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Character> createAnswer() {
        //처음 답 만들 때 새로 초기화 해야함
        List<Character> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            Character randomChar = (char) (randomNumber + '0');

            if (!answer.contains(randomChar)) {
                answer.add(randomChar);
            }
        }

        return answer;
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public List<Integer> setAnswer() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

    public int[] checkAnswer(List<Integer> answer, List<Integer> input) {
        int strike = 0, ball = 0;

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                if(Objects.equals(answer.get(i), input.get(j))) {
                    if(i == j) strike++;
                    else ball++;
                }
            }
        }

        return new int[]{strike, ball};
    }
}

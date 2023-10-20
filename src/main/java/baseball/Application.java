package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 1부터 9까지 서로 다른 수로 이루어진 3자리의 수 생성
        List<Integer> computer = generateRandom(3);
    }

    private static List<Integer> generateRandom(Integer length) {
        List<Integer> result = new ArrayList<>();
        while (result.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }
}

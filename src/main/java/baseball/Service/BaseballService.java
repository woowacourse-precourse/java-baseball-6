package baseball.Service;

import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballService {

    Map<String, Integer> strikeBallCount = new HashMap<>();

    public Map<String, Integer> getStrikeBallCount(List<Character> randomNumbers, List<Character> inputNumbers) {
        int strikeCount = getStrikeCount(randomNumbers, inputNumbers);
        int ballCount = getBallCount(randomNumbers, inputNumbers);
        strikeBallCount.put("ball", ballCount);
        strikeBallCount.put("strike", strikeCount);
        return strikeBallCount;

    }

    public List<Character> createRandomNumberList() {
        List<Character> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            char randomNumber = (char) (Randoms.pickNumberInRange(1, 9) + '0');
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public static int getStrikeCount(List<Character> randomNumbers, List<Character> inputNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (inputNumbers.get(i) == randomNumbers.get(i)) {
                strikeCount++;
                inputNumbers.set(i, 'c');
                continue;
            }
        }
        return strikeCount;
    }

    public static int getBallCount(List<Character> randomNumbers, List<Character> inputNumbers) {
        int ballCount = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            char findNumber = inputNumbers.get(i);
            if (findNumber == 'c') {
                continue;
            }
            if (!randomNumbers.contains(findNumber)) {
                continue;
            }
            if (inputNumbers.get(randomNumbers.indexOf(findNumber)) == 'c') {
                continue;
            }
            int ballIndex = searchBall(findNumber, randomNumbers);
            inputNumbers.set(i, 'c');
            Collections.swap(inputNumbers, i, ballIndex);
            ballCount++;
        }
        return ballCount;
    }

    public static int searchBall(char findNumber, List<Character> randomNumbers) {
        int ballIndex = 0;

        for (int j = 0; j < randomNumbers.size(); j++) {
            if (findNumber == randomNumbers.get(j)) {
                ballIndex = j;
                break;
            }
        }
        return ballIndex;
    }

}

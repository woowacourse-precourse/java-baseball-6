package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    private List<Integer> randomValue = new ArrayList<>(3);
    private List<Integer> result = new ArrayList<>(Arrays.asList(0, 0));

    public void makeRandom() {
        randomValue.clear();
        while (randomValue.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomValue.contains(randomNumber)) {
                randomValue.add(randomNumber);
            }
        }
    }

    public List<Integer> getResult(List<Integer> input) {
        checkBall(input);
        checkStrike(input);
        return result;
    }

    private void checkBall(List<Integer> input) {
        int count = 0;

        for (int i = 0; i < input.size(); i++) {
            if (!input.get(i).equals(randomValue.get(i)) && randomValue.contains(input.get(i))) {
                count++;
            }
        }

        result.set(0, count);
    }

    private void checkStrike(List<Integer> input) {
        int count = 0;

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals(randomValue.get(i))) {
                count++;
            }
        }

        result.set(1, count);
    }

    public boolean showResult(List<Integer> input) {
        List<Integer> result = getResult(input);

        int ballCount = result.get(0);
        int strikeCount = result.get(1);

        if ((ballCount + strikeCount) == 0) {
            System.out.println("낫싱");
        } else {
            String output = "";
            if (ballCount > 0) {
                output += ballCount + "볼 ";
            }
            if (strikeCount > 0) {
                output += strikeCount + "스트라이크";
            }
            if (strikeCount == 3) {
                output += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
                System.out.println(output);
                return true;
            }
            System.out.println(output);
        }
        return false;
    }

}

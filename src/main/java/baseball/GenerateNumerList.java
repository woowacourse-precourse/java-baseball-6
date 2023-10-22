package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GenerateNumerList {

    public void generateInputNumberList(String inputNumber, List<Integer> inputNumberList) {
        for (int i = 0; i < 3; i++) {
            inputNumberList.add(Integer.parseInt(String.valueOf(inputNumber.charAt(i))));
        }
    }

    public void generateRandomNumberList(List<Integer> randomNumberList) {
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
    }
}

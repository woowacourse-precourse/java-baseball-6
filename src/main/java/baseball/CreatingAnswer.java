package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CreatingAnswer {

    private int randomNumber;

    public CreatingAnswer() {
    }

    public int getRandomNumber() {

        ArrayList<Integer> randomList = new ArrayList<>();
        while (randomList.size() < 3) {
            int tempNum = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(tempNum)) {
                randomList.add(tempNum);
            }
        }

        String str = randomList.stream()
                .map(Object::toString)
                .collect(Collectors.joining());

        randomNumber = Integer.parseInt(str);

        return randomNumber;
    }

}

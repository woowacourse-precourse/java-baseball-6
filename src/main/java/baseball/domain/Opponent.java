package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.List;

import static baseball.constant.NumberConstant.*;

public class Opponent {

    private Numbers numbers;

    private Opponent() {
    }

    public static Opponent create() {
        Opponent opponent = new Opponent();
        opponent.setNumbers(Numbers.create(createNumberList()));

        return opponent;
    }

    private static List<Integer> createNumberList() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }

        return numberList;
    }

    private void setNumbers(Numbers numbers) {
        this.numbers = numbers;
    }
}

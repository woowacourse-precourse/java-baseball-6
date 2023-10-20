package baseball.vo;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputerNumber {

    private List<Integer> numberList = null;

    private static final ComputerNumber INSTANCE = new ComputerNumber();

    private ComputerNumber() {
    }

    public List<Integer> createNumberList() {
        numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }

        return numberList;
    }

    public List<Integer> getNumberList() {
        Optional<List<Integer>> optionalNumbers = Optional.ofNullable(numberList);
        return optionalNumbers.orElseGet(this::createNumberList);
    }

    public static ComputerNumber getInstance() {
        return INSTANCE;
    }
}

package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballComputer implements Computer {
    private List<Integer> numbers;

    public BaseballComputer() {
        createNumbers();
    }

    public void createNumbers() {
        List<Integer> createdNumbers = new ArrayList<>();

        while (createdNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!createdNumbers.contains(randomNumber)) {
                createdNumbers.add(randomNumber);
            }
        }

//        System.out.println(createdNumbers);

        this.numbers = createdNumbers;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}

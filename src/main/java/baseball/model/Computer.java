package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private Integer computerNumber1;

    private Integer computerNumber2;

    private Integer computerNumber3;

    // initComputerNumbers : 컴퓨터가 서로 다른 랜덤한 3개의 숫자를 뽑는다.
    public void initComputerNumbers() {
        computerNumber1 = Randoms.pickNumberInRange(1, 9);
        computerNumber2 = Randoms.pickNumberInRange(1, 9);
        while (computerNumber1.equals(computerNumber2)) {
            computerNumber2 = Randoms.pickNumberInRange(1, 9);
        }
        computerNumber3 = Randoms.pickNumberInRange(1, 9);
        while (computerNumber1.equals(computerNumber3) || computerNumber2.equals(computerNumber3)) {
            computerNumber3 = Randoms.pickNumberInRange(1, 9);
        }
    }

    // getNumberList : 컴퓨터가 뽑은 3개의 숫자를 순서대로 넣어서 List로 반환한다.
    public List<Integer> getNumberList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(computerNumber1);
        numbers.add(computerNumber2);
        numbers.add(computerNumber3);
        return numbers;
    }

}

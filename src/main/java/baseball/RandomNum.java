package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNum {
    private final static int MIN_RANDOM_RANGE = 1;
    private final static int MAX_RANDOM_RANGE = 9;
    private final static int COMPUTER_NUM_SIZE = 3;


    private final List<Integer> computer = new ArrayList<>();

    private List<Integer> ComputerSet() {


        System.out.println("숫자 야구 게임을 시작합니다.");
        while (computer.size() < COMPUTER_NUM_SIZE) {
            setComputerPrice(Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE));


        }
        return computer;
    }
    public void setComputerPrice(int price) {

        if (!computer.contains(price)) {
            computer.add(price);
        }
        if (computer.size() == 3) {
            System.out.println(computer);
        }
    }


}

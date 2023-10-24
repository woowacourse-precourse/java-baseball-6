package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private static final Computer computer = new Computer();
    private Computer() {}
    public static Computer getComputer() {
        return computer;
    }

    public List<Integer> makeRandomList(List<Integer> list) {
        while (list.size() < 3) {
            int randomNumber = makeRandomNum();
            if (!list.contains(randomNumber)) list.add(randomNumber);
        }
        return list;
    }
    private int makeRandomNum() {
        return Randoms.pickNumberInRange(1, 9);
    }
}

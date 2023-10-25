package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballNumber {
    private List<Integer> computer;
    private List<Integer> user;

    public BaseballNumber() {
        setComputer();
    }

    private void setComputer() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void setUser(String string) {
        user = Arrays.stream(string.split(""))
                .mapToInt(Integer::valueOf)
                .boxed()
                .distinct()
                .toList();
        if (user.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

}

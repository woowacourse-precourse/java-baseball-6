package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameNumber {
    public List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> convertUserNumber(int userNumber) {
        List<Integer> user = new ArrayList<>();
        user.add(userNumber / 100);
        user.add((userNumber / 10) % 10);
        user.add(userNumber % 10);
        return user;
    }
}
package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberControl {
    public static List<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> getUserNumber() {
        String userNumber = UserInput.userNumber();
        List<Integer> user = new ArrayList<>();
        user.add(Character.getNumericValue(userNumber.charAt(0)));
        user.add(Character.getNumericValue(userNumber.charAt(1)));
        user.add(Character.getNumericValue(userNumber.charAt(2)));

        return user;
    }
}

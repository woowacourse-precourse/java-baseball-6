package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<String> RandomNumber = new ArrayList<>();
    String computer;

    public String CreateNumber() {
        while (RandomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            CheckRepeatNumber(randomNumber);
        }
        computer = String.join("", RandomNumber);
        return computer;
    }

    public void CheckRepeatNumber(int randomNumber) {
        String randomNumberString = Integer.toString(randomNumber);
        if(!RandomNumber.contains(randomNumberString)) {
            RandomNumber.add(randomNumberString);
        }
    }

}

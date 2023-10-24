package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    }

    public static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputUserNumber(){
        String s = Console.readLine();
        List<Integer> inputNumber = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            inputNumber.add(s.charAt(i) - '0');
        }
        return inputNumber;
    }
}

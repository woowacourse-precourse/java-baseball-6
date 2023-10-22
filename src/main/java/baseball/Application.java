package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        String number1 = readLine();
        String number2 = readLine();
        String number3 = readLine();
        List<String> number = new ArrayList<>();
        number.add(number1);
        number.add(number2);
        number.add(number3);
        System.out.println(number);
    }
}

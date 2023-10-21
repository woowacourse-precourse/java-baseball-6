package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static class Computer {
        public List<Integer> computerNumber() {
            List<Integer> number = new ArrayList<>();
            while (number.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!number.contains(randomNumber)) {
                    number.add(randomNumber);
                }
            }
            return number;
        }
    }
    public static void main(String[] args) {
        Computer com = new Computer();
        System.out.println(com.computerNumber().toString());
    }
}

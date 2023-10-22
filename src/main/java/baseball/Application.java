package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        selectNumbers();
        String input = inputNumbers();
        isStrikeOrBall(selectNumbers(), input);
    }

    public static List<Integer> selectNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String inputNumbers() {
        return Console.readLine();
    }

    public static void isStrikeOrBall(List<Integer> computer, String input) {
        int cntStrike = 0;
        int cntBall = 0;
        for(int i=0; i<computer.size(); i++) {
            char num = input.charAt(i);
            if(Character.getNumericValue(num) == computer.get(i)) {
                cntStrike += 1;
            } else if (computer.contains(num)) {
                cntBall += 1;
            }
        }
    }


}

package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<Integer> computer = makeRandomNumbers();

        String input;
        System.out.println("숫자 야구 게임을 시작합니다.");

        outer:
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            List<Integer> inputNumbers = toIntegerArray(input);
            break outer;
        }
    }

    private static List<Integer> toIntegerArray(String input) {
        final List<Integer> inputList = new ArrayList<>();
        for (String s : input.split("")) {
            inputList.add(Integer.valueOf(s));
        }
        return inputList;
    }

    public static List<Integer> makeRandomNumbers() {
        final List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

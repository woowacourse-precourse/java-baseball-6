package baseball;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void main(String[] args) {
        List<Integer> computer = getRandomList();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String data = readLine().trim();
            isValidInput(data);
        }
    }

    private static void isValidInput(final String input) {
        if (input.length() != 3 || !input.matches("\\d+") ||
                input.charAt(0) == input.charAt(1) ||
                input.charAt(0) == input.charAt(2) ||
                input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> getRandomList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        // computer 숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int computerNumber = 100 * computer.get(0) + 10 * computer.get(1) + computer.get(2);
        System.out.println(computer);
        System.out.println(computerNumber);

        System.out.print("숫자를 입력해주세요 : ");
        String numberStr = readLine();
        System.out.println(numberStr);

        boolean isDifferentThreeDigit = isDifferentThreeDigit(numberStr);
        if (isDifferentThreeDigit) {
            System.out.println(numberStr); // 게임 지속
        }

    }
    public static boolean isDifferentThreeDigit(String numberStr) {
        // 숫자가 아닐 때
        try {
            Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        // 3자리가 아닐때
        if (numberStr.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        // 같은 숫자가 있을 때
        char digit1 = numberStr.charAt(0);
        char digit2 = numberStr.charAt(1);
        char digit3 = numberStr.charAt(2);
        if (digit1 == digit2 || digit1 == digit3 || digit2 == digit3) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자가 아닙니다.");
        }
        return true;
    }
}

class Game {

}
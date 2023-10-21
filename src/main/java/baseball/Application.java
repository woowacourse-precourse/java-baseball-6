package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean isStringAllDigits(String input) {
        if (input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO: 사용자가 입력한 수를 컴퓨터가 입력한 수와 비교하며 ball 갯수와 strike 갯수를 세는 기능 구현
        boolean continueGame = true;
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> user = new ArrayList<>();
            String userInput;
            userInput = Console.readLine();
            if (userInput.length() != 3 || !isStringAllDigits(userInput)) {
                throw new IllegalArgumentException(userInput);
            }

            for (char c : userInput.toCharArray()) {
                user.add(Character.getNumericValue(c));
            }
        } while (continueGame);
        System.out.println("게임 종료");
    }
}

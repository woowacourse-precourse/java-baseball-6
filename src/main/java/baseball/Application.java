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
        // TODO: 결과에 따라 흐름을 분기하는 기능 구현
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
            int ballCount = 0;
            int strikeCount = 0;
            for (int i = 0; i < 3; i++) {
                if (computer.get(i) == user.get(i)) {
                    strikeCount++;
                } else if (computer.contains(user.get(i))) {
                    ballCount++;
                }
            }
        } while (continueGame);
        System.out.println("게임 종료");
    }
}

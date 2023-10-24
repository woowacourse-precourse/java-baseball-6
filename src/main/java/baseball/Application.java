package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;


public class Application {

    public static String pickNumber() {
        ArrayList<Integer> computer = new ArrayList<>();
        int result = 0;
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                result = result * 10 + randomNumber;
            }
        }
        return Integer.toString(result);
    }

    public static String validateUserInput() {
        String userInput = Console.readLine();
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            try {
                String userInput = validateUserInput();
                System.out.printf("User : %s, Cpu : %s\n", userInput, pickNumber());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

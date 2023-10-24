package baseball;

// import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class UserInputValidator {
    public int[] getUserInput() {
        
        int[] userInput = new int[3];

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if (input.length() != 3) {
                System.out.println("입력은 3자리 숫자여야 합니다.");
                throw new IllegalArgumentException("잘못 입력한 값입니다.");
            }

            try {
                for (int i = 0; i < 3; i++) {
                    userInput[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
                    if (userInput[i] < 1 || userInput[i] > 9) {
                        throw new NumberFormatException();
                    }
                }
                if (userInput[0] == userInput[1] || userInput[0] == userInput[2] || userInput[1] == userInput[2]) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("1부터 9 사이의 서로 다른 숫자를 입력해주세요.");
                throw new IllegalArgumentException("잘못 입력한 값입니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("서로 다른 숫자를 입력해주세요.");
                throw new IllegalArgumentException("잘못 입력한 값입니다.");
            }
        }

        return userInput;
    }
}

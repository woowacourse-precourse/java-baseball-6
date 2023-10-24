package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    static final String ERROR_MESSAGE = "[error] 올바르지 않은 입력입니다.";
    static final int MAX_NUMBERS = 3;

    public static void main(String[] args) throws IllegalArgumentException {
        String try_again = "1";
        boolean is_it_correct;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (try_again.equals("1")) {
            List<Integer> comInputNum = new ArrayList<>();
            getComInputNum(comInputNum);
            do {
                List<Integer> userInputNum = new ArrayList<>();
                System.out.print("숫자를 입력해주세요 : ");
                String userInputString = Console.readLine();
                checkUserInput(userInputString);
                getUserInput(userInputString, userInputNum);
                is_it_correct = compareUserWithCom(userInputNum, comInputNum);
                check3strike(is_it_correct);
            } while (!is_it_correct);
            try_again = restartOrNot();
        }
    }

    static void checkUserInput(String input) throws IllegalArgumentException {
        // Check the input size is 3.
        if (input.length() != MAX_NUMBERS) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        // Check each character is number.
        for (int i = 0; i < MAX_NUMBERS; i++) {
            if (!(input.charAt(i) >= '1' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
        // Check number are different each other.
        char firstNum = input.charAt(0);
        char secondNum = input.charAt(1);
        char thirdNum = input.charAt(2);
        if ((firstNum == secondNum) || (firstNum == thirdNum) || (secondNum == thirdNum)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    static void getUserInput(String userInputString, List<Integer> userInputNum) {
        // Convert user input from a string to an integer ArrayList.
        for (int i = 0; i < MAX_NUMBERS; i++) {
            int userNumber = userInputString.charAt(i);
            userInputNum.add(userNumber - '0');
        }
    }

    static void getComInputNum(List<Integer> comInputNum) {
        // Generate the computer's numbers.
        while (comInputNum.size() < MAX_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comInputNum.contains(randomNumber)) {
                comInputNum.add(randomNumber);
            }
        }
    }

    static boolean compareUserWithCom(List<Integer> userInputNum, List<Integer> comInputNum) {
        // Compare user input numbers with computer's numbers.
        int ball_count = 0;
        int strike_count = 0;
        boolean is_it_correct = false;
        for (int i = 0; i < MAX_NUMBERS; i++) {
            Integer userNumber = userInputNum.get(i);
            Integer comNumber = comInputNum.get(i);
            if (Objects.equals(userNumber, comNumber)) {
                strike_count++;
            } else if (comInputNum.contains(userNumber)) {
                ball_count++;
            }
        }
        // Print out the game result.
        if (ball_count == 0 && strike_count == 0) {
            System.out.println("낫싱");
        } else if (ball_count != 0 && strike_count == 0) {
            System.out.printf("%d볼\n", ball_count);
        } else if (ball_count == 0 && strike_count != 0) {
            System.out.printf("%d스트라이크\n", strike_count);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball_count, strike_count);
        }

        // Check if strike count is 3
        if (strike_count == MAX_NUMBERS) {
            is_it_correct = true;
        }
        return is_it_correct;
    }

    static String restartOrNot() throws IllegalArgumentException {
        // Check if user wants to play the game again.
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String try_again = Console.readLine();
        if (!(try_again.equals("1") || try_again.equals("2"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return try_again;
    }

    static void check3strike(boolean is_it_correct) {
        if (is_it_correct) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}


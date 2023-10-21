package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        int try_again = 1;
        boolean is_it_correct;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (try_again == 1) {
            List<Integer> computerNum = new ArrayList<>();
            getComputerNum(computerNum);
            while (true) {
                List<Integer> userInputNum = new ArrayList<>();
                System.out.print("숫자를 입력해주세요 : ");
                String userInputString = Console.readLine();
                checkUserInput(userInputString);
                getUserInput(userInputString, userInputNum);
                is_it_correct = compareUserWithCom(userInputNum, computerNum);
                if (is_it_correct) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            // Check if user wants to play the game again.
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try_again = Integer.parseInt(Console.readLine());
        }
    }

    static void checkUserInput(String input) throws IllegalArgumentException {
        String errorMessage = "[error] 올바르지 않은 입력입니다.";
        // Check the input size is 3.
        if (input.length() != 3) {
            throw new IllegalArgumentException(errorMessage);
        }
        // Check each character is number.
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
        // Check number are different each other.
        char firstNum = input.charAt(0);
        char secondNum = input.charAt(1);
        char thirdNum = input.charAt(2);
        if (firstNum == secondNum || firstNum == thirdNum || secondNum == thirdNum) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    static void getUserInput(String userInputString, List<Integer> userInputNum) {
        // Convert user input from a string to an integer ArrayList.
        for (int i = 0; i < 3; i++) {
            userInputNum.add(userInputString.charAt(i) - '0');
        }
    }

    static void getComputerNum(List<Integer> computerNum) {
        // Generate the computer's numbers.
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
    }

    static boolean compareUserWithCom(List<Integer> userInputNum, List<Integer> computerNum) {
        // Compare user input numbers with computer's numbers.
        int ball_count = 0;
        int strike_count = 0;
        boolean is_it_correct = false;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(userInputNum.get(i), computerNum.get(i))) {
                strike_count++;
            } else if (computerNum.contains(userInputNum.get(i))) {
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
        if (strike_count == 3) {
            is_it_correct = true;
        }
        return is_it_correct;
    }
}


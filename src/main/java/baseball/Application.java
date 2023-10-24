package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            List<Integer> computer = generateRandomNumber();
            System.out.println("숫자 야구 게임을 시작합니다.");

            boolean correctGuess = false;

            while (!correctGuess) {
                List<Integer> userInput = getUserInput();
            }
        }
    }


    private static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains((randomNumber))) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }


    private static List<Integer> getUserInput() {
        List<Integer> userInput = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();

        try {
            int number = Integer.parseInt(inputString);

            if (number < 100 || number > 999) {
                throw new IllegalArgumentException();
            }

            int digit1 = number % 10;
            int digit2 = (number / 10) % 10;
            int digit3 = number / 100;

            if ((digit1 == digit2) || (digit1 == digit3) || (digit2 == digit3)
                    || (digit1 == 0) || (digit2 == 0) || (digit3 == 0)) {
                throw new IllegalArgumentException();
            }

            userInput.add(digit3);
            userInput.add(digit2);
            userInput.add(digit1);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }

}

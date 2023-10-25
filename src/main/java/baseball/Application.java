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

                correctGuess = checkGuess(userInput, computer);
                if (correctGuess) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String restartChoice = Console.readLine();
            if (!"1".equals(restartChoice) && !"2".equals(restartChoice)) {
                throw new IllegalArgumentException();
            } else if ("2".equals(restartChoice)) {
                break;
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
            if ((digit1 == digit2) || (digit1 == digit3) || (digit2 == digit3)|| (digit1 == 0) || (digit2 == 0)) {
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


    private static boolean checkGuess(List<Integer> userInput, List<Integer> computer) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            int currentUserInput = userInput.get(i);
            int currentComputerValue = computer.get(i);
            if (currentUserInput == currentComputerValue) {
                strike++;
            } else if (computer.contains(currentUserInput)) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
        } else if (strike > 0 || ball > 0) {
            System.out.println((ball > 0 ? ball + "볼" : "") + (strike > 0 && ball > 0 ? " " : "")
                    + (strike > 0 ? strike + "스트라이크" : ""));
        } else {
            System.out.println("낫싱");
        }

        return strike == 3;
    }

}

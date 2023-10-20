package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computerNumbers = selectComputerNumbers();
//            System.out.println(computerNumbers);

            while (true) {
                List<Integer> userNumbers = inputUserNumbers();
//                System.out.println(userNumbers);

                break;
            }

            if (selectUserExit()) {
                break;
            }
        }
    }

    private static List<Integer> selectComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private static List<Integer> inputUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        String userInput;

        System.out.print("숫자를 입력해주세요 : ");
        userInput = Console.readLine();

        for (int i = 0; i < userInput.length(); i++) {
            int number = userInput.charAt(i) - '0';
            userNumbers.add(number);
        }
        return userNumbers;
    }

    private static boolean selectUserExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (userInput.equals("2")) {
            return true;
        }
        else {
            return false;
        }
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            ArrayList<Integer> computerNumber = new ArrayList<>();
            while (computerNumber.size() < 3) {
                int number = Randoms.pickNumberInRange(1, 9);
                if (!computerNumber.contains(number)) {
                    computerNumber.add(number);
                }
            }
            System.out.print("숫자를 입력해주세요 : ");
            String userNumberString = Console.readLine();

            ArrayList<Integer> userNumber = validInput(userNumberString);
        }

    }

    public static ArrayList<Integer> validInput(String inputNumber) {
        ArrayList<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            char numberChar = inputNumber.charAt(i);
            if (!Character.isDigit(numberChar)) {
                throw new IllegalArgumentException("숫자가 아닌 입력이 포함되어 있습니다.");
            }
            userNumber.add((int) numberChar-'0');
        }

        if (userNumber.size() != 3) {
            throw new IllegalArgumentException("입력숫자가 3자리가 아닙니다.");
        }

        Set<Integer> set = new HashSet<>(userNumber);
        if (set.size() != userNumber.size()) {
            throw new IllegalArgumentException("중복되는 숫자가 포함되어 있습니다.");
        }

        for (int number : userNumber) {
            if (number == 0) {
                throw new IllegalArgumentException("입력숫자에 0이 포함되어 있습니다.");
            }
        }
        return userNumber;
    }
}

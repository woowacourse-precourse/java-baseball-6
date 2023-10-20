package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        Judge judge = new Judge();
        String exit; // 종료
        String number; // 유저가 입력한 숫자
        String result; // 유저가 입력한 숫자에 대한 결과

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            List<Integer> c_num = Randoms.pickUniqueNumbersInRange(1, 9, 3);
            String List_to_String = c_num.toString();
            String computer_num = List_to_String.replaceAll("[^0-9]", "");
            do {
                System.out.print("숫자를 입력해주세요 : ");
                number = Console.readLine();
                ErrorManage(number);
                result = judge.isStrike(number, computer_num);
                System.out.println(result);
            } while (!result.equals("3스트라이크"));

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            exit = Console.readLine();
            ErrorManage(exit);
        } while (!exit.equals("2"));

        Console.close();
    }

    private static void ErrorManage(String input) {
        if (input.length() != 3 && input.length() != 1) {
            throw new IllegalArgumentException("input의 길이가 이상합니다.");
        }

        if (input.length() == 3) {
            if (!isNumeric(input)) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
            }

            if (!hasUniqueDigits(input)) {
                throw new IllegalArgumentException("숫자가 서로 다르지 않습니다.");
            }
        }

        if (input.length() == 1) {
            if (!input.equals("1") && !input.equals("2")) {
                throw new IllegalArgumentException("제대로 된 input값이 아닙니다.");
            }
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private static boolean hasUniqueDigits(String str) {
        HashSet<Character> uniqueDigits = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (uniqueDigits.contains(c)) {
                return false;
            }
            uniqueDigits.add(c);
        }
        return true;
    }
}



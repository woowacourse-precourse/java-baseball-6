package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNums = selectComputerNums();
        List<Integer> userInput;
        int[] result;
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = getUserInput();
            result = compareNumber(computerNums, userInput);
            if (result[0] == 0 && result[1] == 0) {
                System.out.print("낫싱");
            }
            if (result[0] > 0) {
                System.out.print(result[0] + "볼 ");
            }
            if (result[1] > 0) {
                System.out.print(result[1] + "스트라이크");
            }
            System.out.println();
            if (result[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String numStr = Console.readLine();
                if (numStr.equals("2")) {
                    break;
                } else {
                    computerNums = selectComputerNums();
                }
            }
        }
    }

    public static List<Integer> selectComputerNums() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            set.add(random);
        }
        return new ArrayList<>(set);
    }

    public static List<Integer> getUserInput() {
        String numStr = Console.readLine();
        Set<Integer> set = new HashSet<>();
        List<Integer> userInput = new ArrayList<>();

        if (numStr.length() != 3) {
            throw new IllegalArgumentException("invalid number");
        }

        for (int i = 0; i < 3; i++) {
            if (1 <= numStr.charAt(i) - '0' && numStr.charAt(i) - '0' <= 9) {
                set.add(numStr.charAt(i) - '0');
            }
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException("invalid number");
        }

        for (int i = 0; i < 3; i++) {
            userInput.add(numStr.charAt(i) - '0');
        }
        return userInput;
    }

    public static int[] compareNumber(List<Integer> computerNums, List<Integer> userInput) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (computerNums.get(i) == userInput.get(i)) {
                result[1]++;
            } else if (computerNums.contains(userInput.get(i))) {
                result[0]++;
            }
        }
        return result;
    }


}

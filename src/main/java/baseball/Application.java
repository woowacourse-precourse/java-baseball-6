package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            ArrayList<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 3) {
                int number = Randoms.pickNumberInRange(1, 9);
                if (!numbers.contains(number)) {
                    numbers.add(number);
                }
            }
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                if (input.length() != 3) {
                    throw new IllegalArgumentException("세 개의 숫자를 입력해주세요.");
                }
                try {
                    Integer.parseInt(input);
                } catch (Exception e) {
                    throw new IllegalArgumentException("숫자가 아닌 값은 입력할 수 없습니다.");
                }
                int strike = 0;
                for (int i = 0; i < 3; i++) {
                    if (numbers.get(i) == input.charAt(i) - '0' ) {
                        strike++;
                    }
                }
                int ball = 0;
                if (numbers.get(0) == input.charAt(1) - '0' || numbers.get(0) == input.charAt(2) - '0' ) {
                    ball++;
                }
                if (numbers.get(1) == input.charAt(0) - '0' || numbers.get(1) == input.charAt(2) - '0' ) {
                    ball++;
                }
                if (numbers.get(2) == input.charAt(0) - '0' || numbers.get(2) == input.charAt(1) - '0' ) {
                    ball++;
                }
                String information = "";
                if (ball != 0) {
                    information = ball + "볼 ";
                }
                if (strike != 0) {
                    information += strike + "스트라이크";
                }
                if (information.isEmpty()) {
                    information = "낫싱";
                }
                System.out.println(information);
                if (strike == 3) {
                    break;
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String endInput = Console.readLine();
            if ("2".equals(endInput)) {
                break;
            } else if (!"1".equals(endInput)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
}

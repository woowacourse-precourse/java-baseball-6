package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        while (true) {
            ArrayList<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 3) {
                int number = Randoms.pickNumberInRange(1, 9);
                if (!numbers.contains(number)) {
                    numbers.add(number);
                }
            }
            while (true) {
               if (input.length() !=3) {
                   throw new IllegalArgumentException("세 개의 숫자를 입력해주세요.");
               }
               try {
                   Integer.parseInt(input);
               } catch (Exception e) {
                   throw new IllegalArgumentException("숫자가 아닌 값은 입력할 수 없습니다.");
               }
            }
        }
    }
}

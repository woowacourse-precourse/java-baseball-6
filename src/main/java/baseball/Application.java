package baseball;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int[] rand_num = new int[3];
        enter_num(rand_num);

        String str;
        System.out.println("숫자 야구 게임을 시작합니다.");
        int strike_num;
        int ball_num;
        String new_game = "0";
        while (!new_game.equals("2")) {
            System.out.print("숫자를 입력해 주세요 : ");
            strike_num = 0;
            ball_num = 0;
            str = Console.readLine();
            char[] list = str.toCharArray();
            if (list.length != 3) throw new IllegalArgumentException("3자리 숫자가 아님");

            int[] intArray = new int[list.length];
            for (int i = 0; i < list.length; i++) intArray[i] = Character.getNumericValue(list[i]);

            for (int i = 0 ; i < intArray.length; ++i) {
                for (int j = 0; j < intArray.length; ++j) {
                    if (intArray[i] == rand_num[j] && i == j) strike_num++;
                    else if (intArray[i] == rand_num[j]) ball_num++;
                }
            }

            if (strike_num == 3) { // 3스트라이크
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                new_game = Console.readLine();
                if (new_game.equals("1") ) enter_num(rand_num);
                else if (!new_game.equals("2")) throw new IllegalArgumentException("올바른 값이 아님");
            }
            else if (ball_num == 0 && strike_num == 0) System.out.println("낫싱");
            else if (ball_num == 0) System.out.printf("%d스트라이크\n", strike_num);
            else if (strike_num == 0) System.out.printf("%d볼\n", ball_num);
            else  System.out.printf("%d볼 %d스트라이크\n", ball_num, strike_num);
        }

    }

    public static void enter_num(int[] rand_num) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < rand_num.length; i++) {
            int num;
            do {
                num = Randoms.pickNumberInRange(1, 9);
            } while (uniqueNumbers.contains(num));
            rand_num[i] = num;
            uniqueNumbers.add(num);
        }
    }
}

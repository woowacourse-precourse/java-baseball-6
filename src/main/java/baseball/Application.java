package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Computer com = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        com.getNumbers();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String player = Console.readLine();
            List<Integer> intArray = new ArrayList<>();
            String[] temp = player.split("");
            for (String str : temp) {
                if (!intArray.contains(Integer.parseInt(str))) {
                    intArray.add(Integer.parseInt(str));
                }
            }
            int ball = 0;
            int strike = 0;
            for (Integer val : intArray) {
                int index = com.isInList(val);
                if (index < 0) {
                    continue;
                }
                if (index == intArray.indexOf(val)) {
                    strike++;
                } else {
                    ball++;
                }
            }
            if (strike != 3) {
                if (ball > 0) {
                    System.out.print(ball + "볼 ");
                }
                if (strike > 0) {
                    System.out.print(strike + "스트라이크");
                }
                if (ball == 0 && strike == 0) {
                    System.out.print("낫싱");
                }
                System.out.println();
                continue;
            }
            System.out.println(strike + "스트라이크");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            player = Console.readLine();
            if (player.equals("1")) {
                com.getClear();
                com.getNumbers();
            }
            if (player.equals("2")) {
                break;
            }
        }
        System.out.println("숫자 야구 게임을 종료합니다.");
        Console.close();
    }
}

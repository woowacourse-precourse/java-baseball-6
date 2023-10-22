package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = getComputerNumber();

        while (true) {
            int ball = 0;
            int strike = 0;
            System.out.print("숫자를 입력해주세요 : ");
            String selectNumber = Console.readLine();
            String[] user = selectNumber.split("");

            if (user.length > 3) {
                throw new IllegalArgumentException();
            }

            for (int i = 0; i < user.length; i++) {
                int number = Integer.parseInt(user[i]);
                if (computer.indexOf(number) == i) {
                    strike++;
                } else if (computer.contains(number)) {
                    ball++;
                }
            }

            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String choose = Console.readLine();
                if(choose.equals("1")) {
                    computer = getComputerNumber();
                    continue;
                }
                if (choose.equals("2")) {
                    break;
                }
                throw new IllegalArgumentException();
            }

            if (strike + ball == 0) {
               System.out.println("낫싱");
            }
            if (strike == 0) {
                System.out.println(ball + "볼");
            }
            if (ball == 0) {
                System.out.println(strike + "스트라이크");
            }
            if (strike != 0 && ball != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
    }

    private static List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 6);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

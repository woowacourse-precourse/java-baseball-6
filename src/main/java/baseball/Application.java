package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> generateValue() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(ranNum)) {
                computer.add(ranNum);
            }
        }
        return computer;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = generateValue();

        boolean isPlay = true;
        while (isPlay) {
            System.out.print("숫자를 입력해주세요 : ");
            String number = Console.readLine();

            if (number.length() != 3 || !number.matches("[1-9]+")) {
                throw new IllegalArgumentException();
            }

            int ball = 0;
            int strike = 0;

            for (int i = 0; i < number.length(); i++) {
                int check = number.charAt(i) - '0';
                if (computer.contains(check)) {
                    if (computer.get(i) == check) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }

            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike > 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 0 && ball > 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int flag = Integer.parseInt(Console.readLine());

                if (flag == 1) {
                    computer = generateValue();
                } else if (flag == 2) {
                    isPlay = false;
                }
            }
        }
    }
}

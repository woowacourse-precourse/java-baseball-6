package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> answer = RandomNumberGenerator.generate();

            while (true) {
                System.out.println("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                if (input.length() != 3) {
                    throw new IllegalArgumentException();
                }

                List<Integer> inputNumber = new ArrayList<>();

                for (int i = 0; i< 3; i ++) {
                    String temp = input.substring(i, i + 1);
                    inputNumber.add(Integer.parseInt(temp));
                }

                BaseballGame.reset();
                BaseballGame.game(answer, inputNumber);

                int strike = BaseballGame.getStrike();
                int ball = BaseballGame.getBall();

                if (strike == 3) break;
                else if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike == 0 && ball != 0) {
                    System.out.println(ball + "볼");
                } else if (strike != 0 && ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼" + strike + "스트라이크");
                }
            }
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String number = Console.readLine();

        if (Integer.parseInt(number) == 2) {
            break;
        }

        }
    }


}

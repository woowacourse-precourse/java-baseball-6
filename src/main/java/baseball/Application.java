package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            List<Integer> computer = new ArrayList<>();
            int intInput = 0;
            String input;

            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (true) {
                int strike = 0, ball = 0;
                System.out.print("숫자를 입력해주세요 : ");
                input = Console.readLine();
                intInput = Integer.parseInt(input);
                if (intInput < 0 || intInput > 999 || hasSameDigits(intInput)) {
                    // 조건에 맞지 않을 경우 IllegalArgumentException 발생
                    throw new IllegalArgumentException("Invalid input: " + input);
                }
                for (int i = 0; i < 3; i++) {
                    if (computer.contains((int) (input.charAt(i) - '0'))) {
                        if (computer.get(i) == (int) (input.charAt(i) - '0')) {
                            strike++;
                        } else ball++;
                    }
                }
                if (ball > 0 || strike > 0) {
                    if (ball > 0) {
                        System.out.print(ball + "볼 ");
                    }
                    if (strike > 0) {
                        System.out.print(strike + "스트라이크");
                    }
                    System.out.println();
                } else {
                    System.out.println("낫싱");
                }
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    input = Console.readLine();
                    intInput = Integer.parseInt(input);
                    if (intInput != 1 || intInput != 2) {
                        throw new IllegalArgumentException();
                    }
                    if (intInput == 1) {
                        break;
                    } else if (intInput == 2) {
                        return;
                    }
                }
            }
        }
    }
    private static boolean hasSameDigits(int number) {
        int digit1 = number % 10;
        int digit2 = (number / 10) % 10;
        int digit3 = (number / 100) % 10;

        return digit1 == digit2 && digit2 == digit3;
    }
}

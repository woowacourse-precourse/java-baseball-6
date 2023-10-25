package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 무한 루프를 통해 게임을 계속해서 진행
        while (true) {
            List<Integer> computer = new ArrayList<>();
            int intInput = 0;
            String input;

            // 컴퓨터가 선택한 3자리 숫자 랜덤 생성
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            System.out.println("숫자 야구 게임을 시작합니다.");

            // 사용자가 올바른 숫자를 입력할 때까지 반복
            while (true) {
                int strike = 0, ball = 0;
                System.out.print("숫자를 입력해주세요 : ");
                input = Console.readLine();
                intInput = Integer.parseInt(input);

                // 입력값이 범위를 벗어나거나 중복된 숫자가 있는 경우 예외발생
                if (intInput < 0 || intInput > 999 || hasSameDigits(intInput)) {
                    throw new IllegalArgumentException("Invalid input: " + input);
                }

                // 사용자 입력과 컴퓨터의 숫자를 비교하여 결과를 계산
                for (int i = 0; i < 3; i++) {
                    if (computer.contains((int) (input.charAt(i) - '0'))) {
                        if (computer.get(i) == (int) (input.charAt(i) - '0')) {
                            strike++;
                        } else ball++;
                    }
                }

                // 결과에 따라 메시지 출력
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

                // 3스트라이크인 경우 게임을 종료하고 재시작 여부를 확인
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    input = Console.readLine();
                    intInput = Integer.parseInt(input);

                    // 입력이 1 또는 2가 아닌 경우 예외 발생
                    if (intInput != 1 && intInput != 2) {
                        throw new IllegalArgumentException("Invalid input: " + input);
                    }

                    // 게임을 재시작하거나 종료
                    if (intInput == 1) {
                        break;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /**
     * 입력받은 숫자에 중복된 자릿수가 있는지 확인합
     *
     * @param number 확인할 숫자
     * @return 중복된 자릿수가 있다면 true, 없다면 false를 반환
     */
    private static boolean hasSameDigits(int number) {
        int digit1 = number % 10;
        int digit2 = (number / 10) % 10;
        int digit3 = (number / 100) % 10;

        return digit1 == digit2 && digit2 == digit3;
    }
}

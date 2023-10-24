package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean go = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (go) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            computer.set(0, 7);
            computer.set(1, 1);
            computer.set(2, 3);
            while (true) {
                int strike = 0, ball = 0;
                int number;
                System.out.print("숫자를 입력해주세요 : ");
                try {
                    number = scanner.nextInt();
                    if (number < 100 || number > 999) {
                        throw new IllegalArgumentException();
                    }
                } catch (InputMismatchException e) {
                    throw new IllegalArgumentException();
                }

                // int -> int[]
                int[] user = new int[3];
                for (int i = 2; i >= 0; i--) {
                    user[i] = number % 10;
                    number /= 10;
                }

                // get strike
                for (int i = 2; i >= 0; i--) {
                    if (computer.get(i) == user[i]) {
                        strike += 1;
                        user[i] = 0;
                    }
                }

                // get ball
                for (int i = 2; i >= 0; i--) {
                    if (user[i] == 0) {
                        continue;
                    }
                    final int q = computer.get(i);
                    if (Arrays.stream(user).anyMatch(n -> n == q)) {
                        ball += 1;
                    }
                }

                //
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike == 0) {
                    System.out.println(ball + "볼");
                } else if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int isContinue = scanner.nextInt();
            if (isContinue == 2) {
                go = false;
            }
        }
    }
}

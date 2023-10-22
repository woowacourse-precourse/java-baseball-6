package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }

            List<Integer> user = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                if (user.contains(input.charAt(i) - '0')) {
                    throw new IllegalArgumentException();
                }
                user.add(input.charAt(i) - '0');
            }

            int strike = 0, ball = 0;

            for (int i = 0; i < computer.size(); i++) {
                for (int j = 0; j < user.size(); j++) {
                    if (computer.get(i).equals(user.get(j))) {
                        if (i == j) {
                            strike++;
                            break;
                        } else {
                            ball++;
                            break;
                        }
                    }
                }
            }
            if (ball > 0 || strike > 0) {
                if (ball > 0) {
                    System.out.print(ball + "볼");
                    if (strike > 0) {
                        System.out.print(" ");
                    }
                }

                if (strike > 0) {
                    System.out.print(strike + "스트라이크");
                }
                System.out.println();

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int exit = Integer.parseInt(Console.readLine());
                    if (exit == 1) {
                        computer = new ArrayList<>();
                        while (computer.size() < 3) {
                            int randomNumber = Randoms.pickNumberInRange(1, 9);
                            if (!computer.contains(randomNumber)) {
                                computer.add(randomNumber);
                            }
                        }
                    } else if (exit == 2) {
                        break;
                    }
                }
            } else {
                System.out.println("낫싱");
            }
        }
    }
}

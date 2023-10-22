package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            /**
             * 컴퓨터 3자리 숫자 구현
             */
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }


            while (true) {

                /**
                 * 사용자 3자리 숫자 입력 구현
                 */
                System.out.print("숫자를 입력해주세요  : ");
                List<Integer> user = new ArrayList<>();
                String userRead = Console.readLine();
                // 3자리 이상 입력했을 때
                if (userRead.length() != 3) throw new IllegalArgumentException("잘못된 입력입니다. " + userRead);

                for (int i = 0; i < 3; i++) {
                    try {
                        int userNum = Integer.parseInt(String.valueOf(userRead.charAt(i)));
                        if (!user.contains(userNum)) {
                            user.add(userNum);
                        } else {
                            // 같은 수를 입력 했을 경우
                            throw new IllegalArgumentException("잘못된 입력입니다. " + userRead);
                        }
                    } catch (NumberFormatException e) {
                        // 숫자를 입력하지 않았을 경우
                        throw new IllegalArgumentException("잘못된 입력입니다. " + userRead);
                    }

                }

                int strike = 0;
                int ball = 0;

                for (int i = 0; i < 3; i++) {
                    if (user.contains(computer.get(i))) {
                        if (user.indexOf(computer.get(i)) == i) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }

                if (strike == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                System.out.println(strike + " " + ball);

                if (strike > 0 && ball > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (strike > 0 && ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else if (ball > 0 && strike == 0) {
                    System.out.println(ball + "볼");
                } else {
                    System.out.println("낫싱");
                }

            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int newGame = Integer.parseInt(Console.readLine());
            if (newGame == 1) {
                continue;
            } else {
                break;
            }



        }












    }
}

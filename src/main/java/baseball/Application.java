package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Integer coin = 0;
        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");

            // 컴퓨터 숫자 랜덤 뽑기
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            int resetcoin = 1;
            while (resetcoin < 2) {
                // 사용자 숫자 입력 받기
                System.out.print("숫자를 입력해주세요 : ");
                String userNumber = Console.readLine();
                String[] user = userNumber.split("");
                if (userNumber.contains("0")) {
                    throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
                }
                // 숫자 범위 미달, 초과 예외 처리
                if (userNumber.length() != 3) {
                    throw new IllegalArgumentException("세자리 숫자를 입력해야 합니다.");
                }
                // 숫자 중복 예외 처리
                if (user[0].equals(user[1])) {
                    throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력해야 합니다.");
                } else if (user[1].equals(user[2])) {
                    throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력해야 합니다.");
                } else if (user[2].equals(user[0])) {
                    throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력해야 합니다.");
                }
                // Null값 예외 처리
                if (user[0].equals(" ")) {
                    throw new IllegalArgumentException("숫자를 입력해주세요.");
                }

                // 게임 시작
                int ball = 0;
                int strike = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (j == k && computer.get(j) == Integer.valueOf(user[k])) {
                            strike++;
                            continue;
                        } else if (j != k && computer.get(j) == Integer.valueOf(user[k])) {
                            ball++;
                            continue;
                        }
                    }
                }
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike > 0 && ball > 0){
                    System.out.println(ball + "볼" + " " + strike + "스트라이크");
                } else if (ball > 0) {
                    System.out.println(ball + "볼");
                } else if (strike > 0) {
                    System.out.println(strike + "스트라이크");
                }

                if (strike == 3) {
                    resetcoin++;
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                }
            }

            // 게임 종료 후 문구 나타내기
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            coin = Integer.valueOf(Console.readLine());
            while (coin != 1 && coin != 2) {
                System.out.println("1(게임 새로 시작)과 2(게임 종료) 중 하나만 선택해주세요. : ");
                coin = Integer.valueOf(Console.readLine());
            }
        } while (coin < 2);
    }
}
